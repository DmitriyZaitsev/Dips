package com.dzaitsev.dips.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.dzaitsev.dips.R;

/**
 * ------------------------ DESCRIPTION ------------------------<br>
 * <br>
 * Created by Dmitriy Zaitsev at 2013-04-25, 17:17.<br>
 */
public class InitialDipsActivity extends Activity {
	private EditText etInitialDips;

	@Override public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.scr_initial_dips);

		final Button bOk = (Button) findViewById(R.id.btn_ok);
		etInitialDips = (EditText) findViewById(R.id.et_initial_dips);
		etInitialDips.setOnKeyListener(new View.OnKeyListener() {
			@Override public boolean onKey(final View v, final int keyCode, final KeyEvent event) {
				if (event.getAction() == KeyEvent.ACTION_DOWN
						&& keyCode == KeyEvent.KEYCODE_ENTER) {
					clickOkButton();
					return true;
				}
				return false;
			}
		});

		bOk.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(final View v) {
				clickOkButton();
			}
		});
	}

	private void clickOkButton() {
		String enteredDips = etInitialDips.getText().toString();
		int initDips = Integer.valueOf(enteredDips);
		if (initDips > 65) {
			showAlertDialog();
		} else {
			startActivity(new Intent(this, MainActivity.class));
			finish();
		}
	}

	private void showAlertDialog() {
		AlertDialog.Builder alertDialog = new AlertDialog.Builder(InitialDipsActivity.this);
		alertDialog.setMessage(R.string.sorry_pal);
		alertDialog.setCancelable(true);
		alertDialog.show();
	}
}