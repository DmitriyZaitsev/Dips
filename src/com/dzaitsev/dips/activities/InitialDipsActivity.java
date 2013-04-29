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
import com.dzaitsev.dips.IDipsPreferences;
import com.dzaitsev.dips.R;
import com.dzaitsev.dips.Sets;

/**
 * ------------------------ DESCRIPTION ------------------------<br>
 * <br>
 * Created by Dmitriy Zaitsev at 2013-04-25, 17:17.<br>
 */
public class InitialDipsActivity extends Activity {
	private final int DIALOG_TOO_COOL = 1;
	private final int DIALOG_TOO_FRAIL = 2;
	private EditText mInitialDips;
	private IDipsPreferences mPrefs;

	@Override protected void onCreate(final Bundle savedInstanceState) {
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

		if (0 <= initDips && initDips < 10) {
			showAlertDialog(DIALOG_TOO_FRAIL);
		} else if (initDips >= 65) {
			showAlertDialog(DIALOG_TOO_COOL);
		} else if (10 <= initDips && initDips < 65) {
			setupUser(initDips);
			startActivity(new Intent(this, MainActivity.class));
			finish();
		}
	}

	private void showAlertDialog(final int id) {
		final AlertDialog.Builder alertDialog = new AlertDialog.Builder(InitialDipsActivity.this);
		if (id == DIALOG_TOO_COOL) {
			alertDialog.setMessage(R.string.sorry_pal_too_cool);
		} else {
			alertDialog.setMessage(R.string.sorry_pal_too_frail);
		}
		alertDialog.setCancelable(true);
		alertDialog.show();
	}

	private void setupUser(final int dips) {
		for (int i = 1; i <= 16; i++) {
			if (Sets.getSet1()[i - 1] <= dips && dips < Sets.getSet1()[i]) {
				mPrefs.setUserLevel(i);
				mPrefs.setDipsInitial(dips);
				mPrefs.setAlreadyRegistered(true);
			}
		}
	}
}