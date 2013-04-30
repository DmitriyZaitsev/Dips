package com.dzaitsev.dips.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.dzaitsev.dips.DipsPreferences;
import com.dzaitsev.dips.IDipsPreferences;
import com.dzaitsev.dips.R;
import com.dzaitsev.dips.exercises.Dips;
import com.dzaitsev.dips.exercises.Exercise;

public class MainActivity extends Activity {
	private final int CODE_REQUEST = 1;
	private Button mDoneButton;
	private Exercise mDips;
	private IDipsPreferences mPrefs;
	private TextView mCurrentTextView;
	private TextView mCompletedTextView;
	private TextView mRemainingTextView;
	private int mUserLevel;
	
	@Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == Activity.RESULT_OK) {
			updateUserProgress();
			if (mDips.getRemaining() <= 0) {
				mDoneButton.setText(R.string.finish);
			}
		} else if (resultCode == Activity.RESULT_CANCELED) {
			//TODO: process RESULT_CANCEL
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
		mCompletedTextView.setText("0");
		mRemainingTextView.setText(String.valueOf(mDips.getRemaining()));

		mDoneButton.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(final View view) {
				if (mDips.getRemaining() <= 0) {
					showAlertDialog();
				} else {
					Intent intent = new Intent(MainActivity.this, TimerActivity.class);
					startActivityForResult(intent, CODE_REQUEST);
				}
			}
		});
	}

	private void initUserProgress() {
		mUserLevel = mPrefs.getUserLevel();
		mDips = new Dips(mUserLevel);
	}

	private void showAlertDialog() {
		final AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
		alertDialog.setMessage(R.string.training_finished);
		alertDialog.setCancelable(true);
		alertDialog.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
			@Override public void onClick(final DialogInterface dialogInterface, final int i) {
				finish();
			}
		});
		alertDialog.show();
	}

	private void updateUserProgress() {
		//TODO: Update user progress
		mDips.confirmSet();

		mCurrentTextView.setText(String.valueOf(mDips.getCurrent()));
		mCompletedTextView.setText(String.valueOf(mDips.getCompleted()));
		mRemainingTextView.setText(String.valueOf(mDips.getRemaining()));
	}
}
