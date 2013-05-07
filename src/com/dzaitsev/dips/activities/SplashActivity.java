package com.dzaitsev.dips.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.dzaitsev.dips.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * ------------------------ DESCRIPTION ------------------------<br>
 * <br>
 * Created by Dmitriy Zaitsev at 2013-04-25, 16:08.<br>
 */
public class SplashActivity extends Activity {
	@Override protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.scr_splash);

		switchScreen();
	}

	private void switchScreen() {
		final Timer timer = new Timer();
		final TimerTask task = new TimerTask() {
			@Override public void run() {
				startActivity(new Intent(SplashActivity.this, HelloActivity.class));
				finish();
			}
		};

		timer.schedule(task, 2000);
	}
}
