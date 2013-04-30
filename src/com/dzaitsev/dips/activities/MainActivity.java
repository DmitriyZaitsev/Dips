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

public class MainActivity extends Activity {
	private final int CODE_REQUEST = 1;
	private Button mDoneButton;
	private Dips mDips;
	private IDipsPreferences mPrefs;
	private TextView mCurrentSetTextView;
	private TextView mDoneTextView;
	private TextView mRemainingTextView;
	private int mExercisesDone;
	private int mExercisesRemaining;
	private int mUserLevel;
	
	@Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == Activity.RESULT_OK) {
			updateUserProgress();
			if (mExercisesRemaining <= 0) {
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
		mCurrentSetTextView = (TextView) findViewById(R.id.tv_cur_exercises);
		mDoneTextView = (TextView) findViewById(R.id.tv_done);
		mRemainingTextView = (TextView) findViewById(R.id.tv_remaining);

		mCurrentSetTextView.setText(String.valueOf(mDips.getCurrentDips()));
		mDoneTextView.setText("0");
		mRemainingTextView.setText(String.valueOf(mExercisesRemaining));

		mDoneButton.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(final View view) {
				if (mExercisesRemaining <= 0) {
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

		mExercisesRemaining = mDips.getSet1() + mDips.getSet2() + mDips.getSet3() + mDips
				.getSet4() + mDips.getSet5();
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
		mExercisesDone += mDips.getCurrentDips();
		mExercisesRemaining -= mDips.getCurrentDips();
		mDips.confirmSet();

		mCurrentSetTextView.setText(String.valueOf(mDips.getCurrentDips()));
		mDoneTextView.setText(String.valueOf(mExercisesDone));
		mRemainingTextView.setText(String.valueOf(mExercisesRemaining));
	}
}
