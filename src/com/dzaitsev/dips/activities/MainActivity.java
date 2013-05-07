package com.dzaitsev.dips.activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.dzaitsev.dips.DipsPreferences;
import com.dzaitsev.dips.IDipsPreferences;
import com.dzaitsev.dips.R;
import com.dzaitsev.dips.exercises.Dips;
import com.dzaitsev.dips.exercises.Exercise;

public class MainActivity extends Activity {
	private Button mDoneButton;
	private Exercise mDips;
	private IDipsPreferences mPrefs;
	private TextView mCompletedTextView;
	private TextView mCurrentTextView;
	private TextView mRemainingTextView;

	@Override public void onBackPressed() {
		super.onBackPressed();
		startActivity(new Intent(MainActivity.this, HelloActivity.class));
		finish();
	}

	@Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == Activity.RESULT_OK) {
			updateUserProgress();

			if (mDips.getRemaining() <= 0) {
				mDoneButton.setText(R.string.finish);
			}
		} else if (resultCode == Activity.RESULT_CANCELED) {
			// do nothing
		}
	}

	/** Called when the activity is first created. */
	@Override protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.scr_stats);
		mPrefs = new DipsPreferences(MainActivity.this);
		initUserProgress();

		mDoneButton = (Button) findViewById(R.id.btn_done);
		mCurrentTextView = (TextView) findViewById(R.id.tv_cur_exercises);
		mCompletedTextView = (TextView) findViewById(R.id.tv_done);
		mRemainingTextView = (TextView) findViewById(R.id.tv_remaining);

		mCurrentTextView.setText(String.valueOf(mDips.getCurrent()));
		mCompletedTextView.setText(String.valueOf(mDips.getCompleted()));
		mRemainingTextView.setText(String.valueOf(mDips.getRemaining()));

		mDoneButton.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(final View view) {
				buttonDoneClick();
			}
		});
	}

	private void buttonDoneClick() {
		if (mDips.getRemaining() <= 0) {
			showDialog();
		} else {
			Intent intent = new Intent(this, TimerActivity.class);
			final int ACTIVITY_TIMER = 1;
			startActivityForResult(intent, ACTIVITY_TIMER);
		}
	}

	private void initUserProgress() {
		final int mUserLevel = mPrefs.getUserLevel();
		mDips = new Dips(mUserLevel);
	}

	private void showDialog() {
		final Dialog dialog = new Dialog(MainActivity.this);
		dialog.setCancelable(false);
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialog.setContentView(R.layout.dlg_after_training);
		final Button bEasy = (Button) dialog.findViewById(R.id.btn_easy);
		bEasy.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(final View view) {
				mPrefs.setUserLevel(mPrefs.getUserLevel() + 1);
				dialog.dismiss();
				finish();
			}
		});

		final Button bFine = (Button) dialog.findViewById(R.id.btn_fine);
		bFine.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(final View view) {
				dialog.dismiss();
				finish();
			}
		});

		final Button bHard = (Button) dialog.findViewById(R.id.btn_hard);
		bHard.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(final View view) {
				mPrefs.setUserLevel(mPrefs.getUserLevel() - 1);
				dialog.dismiss();
				finish();
			}
		});
		dialog.show();
	}

	private void updateUserProgress() {
		mDips.confirmSet();

		mCurrentTextView.setText(String.valueOf(mDips.getCurrent()));
		mCompletedTextView.setText(String.valueOf(mDips.getCompleted()));
		mRemainingTextView.setText(String.valueOf(mDips.getRemaining()));
	}
}
