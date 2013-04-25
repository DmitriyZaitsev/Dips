package com.dzaitsev.dips.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.dzaitsev.dips.DipsPreferences;
import com.dzaitsev.dips.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * ------------------------ DESCRIPTION ------------------------<br>
 * <br>
 * Created by Dmitriy Zaitsev at 2013-04-25, 16:08.<br>
 */
public class SplashActivity extends Activity {
	@Override public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.scr_splash);

		switchScreen();
	}

	private void switchScreen() {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override public void run() {
				DipsPreferences dipsPreferences = new DipsPreferences(SplashActivity.this);
				Intent intent;

				if (dipsPreferences.isAlreadyRegistered()) {
					intent = new Intent(SplashActivity.this, MainActivity.class);
				} else {
					intent = new Intent(SplashActivity.this, HelloActivity.class);
				}
				startActivity(intent);
				finish();
			}
		};

		timer.schedule(task, 3000);
	}
}