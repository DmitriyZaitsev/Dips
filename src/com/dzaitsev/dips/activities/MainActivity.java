package com.dzaitsev.dips.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.dzaitsev.dips.DipsPreferences;
import com.dzaitsev.dips.R;
import com.dzaitsev.dips.Tries;

public class MainActivity extends Activity {
	private final int CODE_REQUEST = 1;
	private DipsPreferences mPrefs;
	private TextView mCurrentTry;
	private TextView mDone;
	private TextView mRemaining;
	private int mDipsDone;
	private int mDipsRequired;
	private int mUsersLevel;
	private int mTriesFinished;

	/** Called when the activity is first created. */
	@Override public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.scr_stats);
		mPrefs = new DipsPreferences(MainActivity.this);
		initUserProgress();

		final Button bStart = (Button) findViewById(R.id.btn_start);
		final Button bCancel = (Button) findViewById(R.id.btn_cancel);
		final TextView tvCurrentTry = (TextView) findViewById(R.id.tv_cur_try);
		final TextView tvDone = (TextView) findViewById(R.id.tv_done);
		final TextView tvRemaining = (TextView) findViewById(R.id.tv_remaining);

		tvCurrentTry.setText("Текущий подход: " + String.valueOf(Tries.getTry1()[mUsersLevel]));
		tvDone.setText("Сделано: 0");
		tvRemaining.setText("Осталось: " + String.valueOf(mDipsRequired));

		bStart.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(final View view) {
				Intent intent = new Intent(MainActivity.this, TimerActivity.class);
				startActivityForResult(intent, CODE_REQUEST);
			}
		});
	}

	@Override public void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == Activity.RESULT_OK) {
			//TODO
		} else if (resultCode == Activity.RESULT_CANCELED) {
			//TODO
		}
	}

	private void initUserProgress() {
		mUsersLevel = mPrefs.getUsersLevel();
		mDipsRequired = Tries.getTry1()[mUsersLevel] + Tries.getTry2()[mUsersLevel]
				+ Tries	.getTry3()[mUsersLevel] + Tries.getTry4()[mUsersLevel]
				+ Tries	.getTry5()[mUsersLevel];
	}
}