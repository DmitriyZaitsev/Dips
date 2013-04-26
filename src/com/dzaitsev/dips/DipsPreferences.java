package com.dzaitsev.dips;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * ------------------------ DESCRIPTION ------------------------<br>
 * <br>
 * Created by Dmitriy Zaitsev at 2013-04-25, 16:13.<br>
 */
public final class DipsPreferences {
	private final String DIPS_PREFERENCES = "DipsPreferences";
	private final String KEY_USERNAME = "username";
	private final String KEY_INITIAL_DIPS = "initial_dips";
	private final String KEY_ALREADY_REGISTERED = "already_registered";
	private final String KEY_USERS_LEVEL = "users_level";
	private SharedPreferences sharedPreferences;
	private SharedPreferences.Editor preferencesEditor;

	public DipsPreferences(Context context) {
		sharedPreferences = context.getSharedPreferences(DIPS_PREFERENCES, Context.MODE_PRIVATE);
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

	public int getUsersLevel() {
		return sharedPreferences.getInt(KEY_USERS_LEVEL, 0);
	}

	public void setUsersLevel(int level) {
		preferencesEditor.putInt(KEY_USERS_LEVEL, level);
		preferencesEditor.commit();
	}
}
