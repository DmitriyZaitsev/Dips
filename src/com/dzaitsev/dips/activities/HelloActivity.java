package com.dzaitsev.dips.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.dzaitsev.dips.R;

/**
 * ------------------------ DESCRIPTION ------------------------<br>
 * <br>
 * Created by Dmitriy Zaitsev at 2013-04-25, 16:35.<br>
 */
public class HelloActivity extends Activity {

	@Override protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.scr_hello);

		final Button bYes = (Button) findViewById(R.id.btn_yes);
		final Button bNo = (Button) findViewById(R.id.btn_no);

		bYes.setOnClickListener(new View.OnClickListener() {

			@Override public void onClick(final View v) {
				startActivity(new Intent(HelloActivity.this, InitialDipsActivity.class));
				finish();
			}
		});
		bNo.setOnClickListener(new View.OnClickListener() {

			@Override public void onClick(final View v) {
				finish();
			}
		});
	}
}
