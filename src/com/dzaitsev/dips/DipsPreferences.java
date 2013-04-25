package com.dzaitsev.dips;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * ------------------------ DESCRIPTION ------------------------<br>
 * <br>
 * Created by Dmitriy Zaitsev at 2013-04-25, 16:13.<br>
 */
public final class DipsPreferences {
	private SharedPreferences sharedPreferences;
	private SharedPreferences.Editor preferencesEditor;
	private String DIPS_PREFERENCES = "DipsPreferences";
	private String KEY_USERNAME = "username";
	private String KEY_INITIAL_DIPS = "initial_dips";
	private String KEY_ALREADY_REGISTERED = "already_registered";

	public DipsPreferences(Context context) {
		sharedPreferences = context.getSharedPreferences(DIPS_PREFERENCES,
				Context.MODE_PRIVATE);
		preferencesEditor = sharedPreferences.edit();
	}

	public String getUsername() {
		return sharedPreferences.getString(KEY_USERNAME, "Unknown User");
	}

	public void setUsername(String name) {
		preferencesEditor.putString(KEY_USERNAME, name);
		preferencesEditor.commit();
	}

	public int getInitialDips() {
		return sharedPreferences.getInt(KEY_INITIAL_DIPS, 0);
	}

	public void setInitialDips(int amount) {
		preferencesEditor.putInt(KEY_INITIAL_DIPS, amount);
		preferencesEditor.commit();
	}

	public boolean isAlreadyRegistered() {
		return sharedPreferences.getBoolean(KEY_ALREADY_REGISTERED, false);
	}

	public void setAlreadyRegistered(boolean registered) {
		preferencesEditor.putBoolean(KEY_ALREADY_REGISTERED, registered);
		preferencesEditor.commit();
	}
}
