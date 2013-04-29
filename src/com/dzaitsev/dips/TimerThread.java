package com.dzaitsev.dips;

import android.app.Activity;
import android.os.Handler;

import java.util.concurrent.TimeUnit;

/**
 * ------------------------ DESCRIPTION ------------------------<br>
 * <br>
 * Created by Dmitriy Zaitsev at 2013-04-25, 14:40.<br>
 */
public class TimerThread implements Runnable {
	private final Handler mHandler;

	public TimerThread(final Handler handler) {
		mHandler = handler;
	}

	@Override public void run() {
		for (int seconds = 90; seconds >= 1; seconds--) {
			mHandler.sendEmptyMessage(seconds);
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
				mHandler.sendEmptyMessage(Activity.RESULT_CANCELED);
			}
		}
		mHandler.sendEmptyMessage(Activity.RESULT_OK);
	}
}
