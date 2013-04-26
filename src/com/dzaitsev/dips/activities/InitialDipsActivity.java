package com.dzaitsev.dips.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.dzaitsev.dips.DipsPreferences;
import com.dzaitsev.dips.R;
import com.dzaitsev.dips.Tries;

/**
 * ------------------------ DESCRIPTION ------------------------<br>
 * <br>
 * Created by Dmitriy Zaitsev at 2013-04-25, 17:17.<br>
 */
public class InitialDipsActivity extends Activity {
	private EditText mInitialDips;
	private DipsPreferences mPrefs;

	@Override public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.scr_initial_dips);
		mPrefs = new DipsPreferences(InitialDipsActivity.this);

		final Button bOk = (Button) findViewById(R.id.btn_ok);
		mInitialDips = (EditText) findViewById(R.id.et_initial_dips);
		mInitialDips.setOnKeyListener(new View.OnKeyListener() {
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
		final String enteredDips = mInitialDips.getText().toString();
		final int initDips = Integer.valueOf(enteredDips);

		if (0 <= initDips && initDips < 65) {
			setupUserLevel(initDips);
			mPrefs.setAlreadyRegistered(true);
			startActivity(new Intent(this, MainActivity.class));
			finish();
		} else if (initDips >= 65) {
			showAlertDialog();
		}
	}

	private void showAlertDialog() {
		final AlertDialog.Builder alertDialog = new AlertDialog.Builder(InitialDipsActivity.this);
		alertDialog.setMessage(R.string.sorry_pal);
		alertDialog.setCancelable(true);
		alertDialog.show();
	}

	private void setupUserLevel(int dips) {
		if (dips < Tries.getTry1()[0]) {
			mPrefs.setUsersLevel(0);
		} else {
			for (int i = 1; i <= 16; i++) {
				if (Tries.getTry1()[i - 1] <= dips && dips < Tries.getTry1()[i]) {
					mPrefs.setUsersLevel(i);
				}
			}
		}
	}
}