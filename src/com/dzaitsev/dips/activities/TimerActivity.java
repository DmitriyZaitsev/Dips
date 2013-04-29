package com.dzaitsev.dips.activities;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.dzaitsev.dips.R;
import com.dzaitsev.dips.TimerThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ------------------------ DESCRIPTION ------------------------<br>
 * <br>
 * Created by Dmitriy Zaitsev at 2013-04-25, 14:40.<br>
 */
public class TimerActivity extends Activity {
	private ExecutorService mExecutorService;
	private Handler mHandler;
	private ImageView mDigitLeft;
	private ImageView mDigitRight;

	@Override public void onBackPressed() {
		super.onBackPressed();
		setResultCancelAndFinish();
	}

	@Override protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.scr_timer);

		mDigitLeft = (ImageView) findViewById(R.id.iv_digit_left);
		mDigitRight = (ImageView) findViewById(R.id.iv_digit_right);
		final Button mProceed = (Button) findViewById(R.id.btn_proceed);

		mProceed.setOnClickListener(new View.OnClickListener() {

			@Override public void onClick(final View view) {
				setResultOkAndFinish();
			}
		});

		mHandler = new UiUpdateHandler();
		mExecutorService = Executors.newSingleThreadExecutor();
	}

	@Override protected void onPause() {
		super.onPause();
		mExecutorService.shutdown();
	}

	@Override protected void onResume() {
		super.onResume();
		mExecutorService.execute(new TimerThread(mHandler));
	}

	private void setResultCancelAndFinish() {
		setResult(Activity.RESULT_CANCELED);
		finish();
	}

	private void setResultOkAndFinish() {
		setResult(Activity.RESULT_OK);
		finish();
	}

	private class UiUpdateHandler extends Handler {

		@Override public void handleMessage(final Message message) {
			if (message.what == Activity.RESULT_OK) {
				setResultOkAndFinish();
			} else if (message.what == Activity.RESULT_CANCELED) {
				setResultCancelAndFinish();
			} else {
				int seconds = message.what - 1;
				int leftDigit = seconds / 10;

				if (seconds % 10 == 9) {
					switchDigit(mDigitLeft, leftDigit);
				}
				int rightDigit = seconds - leftDigit * 10;
				switchDigit(mDigitRight, rightDigit);
			}
		}

		private void switchDigit(final ImageView iv, final int digit) {
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
}
