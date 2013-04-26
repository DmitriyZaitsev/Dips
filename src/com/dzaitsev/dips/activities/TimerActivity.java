package com.dzaitsev.dips.activities;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import com.dzaitsev.dips.R;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * ------------------------ DESCRIPTION ------------------------<br>
 * <br>
 * Created by Dmitriy Zaitsev at 2013-04-25, 14:40.<br>
 */
public class TimerActivity extends Activity {
	private ImageView ivDigitLeft;
	private ImageView ivDigitRight;
	private ExecutorService executorService;

	@Override public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.scr_timer);

		ivDigitLeft = (ImageView) findViewById(R.id.iv_digit_left);
		ivDigitRight = (ImageView) findViewById(R.id.iv_digit_right);

		Handler handler = new UiUpdateHandler();
		executorService = Executors.newSingleThreadExecutor();
		executorService.execute(new TimerThread(handler));
	}

	@Override public void onBackPressed() {
		executorService.shutdown();
		setResult(Activity.RESULT_CANCELED);
		finish();
	}

	private class UiUpdateHandler extends Handler {
		@Override public void handleMessage(Message seconds) {
			int leftDigit = seconds.what / 10;

			if (seconds.what % 10 == 9) {
				switchDigit(ivDigitLeft, leftDigit);
			}
			int rightDigit = seconds.what - leftDigit * 10;
			switchDigit(ivDigitRight, rightDigit);
		}

		private void switchDigit(ImageView iv, int digit) {
			switch (digit) {
				case 0:
					iv.setBackgroundResource(R.drawable.digit_0);
					break;
				case 1:
					iv.setBackgroundResource(R.drawable.digit_1);
					break;
				case 2:
					iv.setBackgroundResource(R.drawable.digit_2);
					break;
				case 3:
					iv.setBackgroundResource(R.drawable.digit_3);
					break;
				case 4:
					iv.setBackgroundResource(R.drawable.digit_4);
					break;
				case 5:
					iv.setBackgroundResource(R.drawable.digit_5);
					break;
				case 6:
					iv.setBackgroundResource(R.drawable.digit_6);
					break;
				case 7:
					iv.setBackgroundResource(R.drawable.digit_7);
					break;
				case 8:
					iv.setBackgroundResource(R.drawable.digit_8);
					break;
				case 9:
					iv.setBackgroundResource(R.drawable.digit_9);
					break;
				default:
					iv.setBackgroundResource(R.drawable.digit_9);
					break;
			}
		}
	}

	private class TimerThread implements Runnable {
		private Handler handler;

		protected TimerThread(Handler handler) {
			this.handler = handler;
		}

		@Override public void run() {
			for (int seconds = 89; seconds >= 0; seconds--) {
				handler.sendEmptyMessage(seconds);
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
					onBackPressed();
				}
			}
			setResult(Activity.RESULT_OK);
			finish();
		}
	}
}