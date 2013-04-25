package com.dzaitsev.dips.activities;

import android.app.Activity;
import android.os.Bundle;
import com.dzaitsev.dips.R;

/**
 * ------------------------ DESCRIPTION ------------------------<br>
 * <br>
 * Created by Dmitriy Zaitsev at 2013-04-25, 14:40.<br>
 */
public class TimerActivity extends Activity {
	@Override public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.scr_timer);
	}

	@Override public void onBackPressed() {
		setResult(Activity.RESULT_CANCELED);
		finish();
	}
}