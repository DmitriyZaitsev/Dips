package com.dzaitsev.dips.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.dzaitsev.dips.Dips;
import com.dzaitsev.dips.DipsPreferences;
import com.dzaitsev.dips.IDipsPreferences;
import com.dzaitsev.dips.R;
import com.dzaitsev.dips.Sets;

public class MainActivity extends Activity {
	private final int CODE_REQUEST = 1;
	private Dips mDips;
	private IDipsPreferences mPrefs;
	private TextView mCurrentSetTextView;
	private TextView mDoneTextView;
	private TextView mRemainingTextView;
	private int mDipsDone;
	private int mDipsRemaining;
	private int mTriesFinished;
	private int mUserLevel;

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
		final TextView tvCurrentSet = (TextView) findViewById(R.id.tv_cur_set);
		final TextView tvDone = (TextView) findViewById(R.id.tv_done);
		final TextView tvRemaining = (TextView) findViewById(R.id.tv_remaining);

		tvCurrentSet.setText(String.valueOf(Sets.getSet1()[mUserLevel]));
		tvDone.setText("0");
		tvRemaining.setText(String.valueOf(mDipsRemaining));

		bDone.setOnClickListener(new View.OnClickListener() {

			@Override public void onClick(final View view) {
				updateUserProgress();
				Intent intent = new Intent(MainActivity.this, TimerActivity.class);
				startActivityForResult(intent, CODE_REQUEST);
			}
		});
	}

	private void initUserProgress() {
		mUserLevel = mPrefs.getUserLevel();
		mDips = new Dips(mUserLevel);

		mDipsRemaining = mDips.getSet1() + mDips.getSet2() + mDips.getSet3() + mDips
				.getSet4() + mDips.getSet5();
	}

	private void updateUserProgress() {
		//TODO: Update user progress
		mDips.confirmSet();
		mCurrentSetTextView.setText(String.valueOf(mDips.getCurrentDips()));
	}
}
