package com.dzaitsev.dips.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.dzaitsev.dips.R;

public class MainActivity extends Activity {
	private final int CODE_REQUEST = 1;

	/** Called when the activity is first created. */
	@Override public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.scr_stats);

		Button bStart = (Button) findViewById(R.id.btn_start);
		Button bCancel = (Button) findViewById(R.id.btn_cancel);

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
}