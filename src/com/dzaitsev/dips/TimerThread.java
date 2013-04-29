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
	private final int mSeconds;

	public TimerThread(final Handler handler, final int seconds) {
		mHandler = handler;
		mSeconds = seconds;
	}

	@Override public void run() {
		for (int i = mSeconds; i >= 1; i--) {
			mHandler.sendEmptyMessage(i);
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
