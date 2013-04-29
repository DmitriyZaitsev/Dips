package com.dzaitsev.dips.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.dzaitsev.dips.DipsPreferences;
import com.dzaitsev.dips.IDipsPreferences;
import com.dzaitsev.dips.R;
import com.dzaitsev.dips.Sets;

public class MainActivity extends Activity {
	private final int CODE_REQUEST = 1;
	private IDipsPreferences mPrefs;
	private TextView mCurrentTry;
	private TextView mDone;
	private TextView mRemaining;
	private int mDipsDone;
	private int mDipsRequired;
	private int mTriesFinished;
	private int mUsersLevel;

	@Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == Activity.RESULT_OK) {
			//TODO: process RESULT_OK
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

		final Button bDone = (Button) findViewById(R.id.btn_done);
		final TextView tvCurrentTry = (TextView) findViewById(R.id.tv_cur_try);
		final TextView tvDone = (TextView) findViewById(R.id.tv_done);
		final TextView tvRemaining = (TextView) findViewById(R.id.tv_remaining);

		tvCurrentTry.setText(getString(R.string.current_set) + ": " + String.valueOf(
				Sets.getSet1()[mUsersLevel]));
		tvDone.setText(getString(R.string.done) + ": 0");
		tvRemaining.setText(getString(R.string.remaining) + ": " + String.valueOf(mDipsRequired));

		bDone.setOnClickListener(new View.OnClickListener() {

			@Override public void onClick(final View view) {
				Intent intent = new Intent(MainActivity.this, TimerActivity.class);
				startActivityForResult(intent, CODE_REQUEST);
			}
		});
	}

	private void initUserProgress() {
		mUsersLevel = mPrefs.getUserLevel();
		mDipsRequired = Sets.getSet1()[mUsersLevel] + Sets.getSet2()[mUsersLevel] + Sets
				.getSet3()[mUsersLevel] + Sets.getSet4()[mUsersLevel] + Sets
				.getSet5()[mUsersLevel];
	}

	private void updateUserProgress() {
		//TODO: Update user progress
	}
}