package com.dzaitsev.dips;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * ------------------------ DESCRIPTION ------------------------<br>
 * <br>
 * Created by Dmitriy Zaitsev at 2013-04-25, 16:13.<br>
 */
public final class DipsPreferences {
	@SuppressWarnings("FieldCanBeLocal") private final String DIPS_PREFERENCES = "DipsPreferences";
	private final String KEY_USERNAME = "username";
	private final String KEY_INITIAL_DIPS = "initial_dips";
	private final String KEY_ALREADY_REGISTERED = "already_registered";
	private final String KEY_USERS_LEVEL = "users_level";
	private final SharedPreferences mSharedPreferences;
	private final SharedPreferences.Editor mPreferencesEditor;

	public DipsPreferences(Context context) {
		mSharedPreferences = context.getSharedPreferences(DIPS_PREFERENCES, Context.MODE_PRIVATE);
		mPreferencesEditor = mSharedPreferences.edit();
	}

	public String getUsername() {
		return mSharedPreferences.getString(KEY_USERNAME, "Unknown User");
	}

	public void setUsername(String name) {
		mPreferencesEditor.putString(KEY_USERNAME, name);
		mPreferencesEditor.commit();
	}

	public int getInitialDips() {
		return mSharedPreferences.getInt(KEY_INITIAL_DIPS, 0);
	}

	public void setInitialDips(int amount) {
		mPreferencesEditor.putInt(KEY_INITIAL_DIPS, amount);
		mPreferencesEditor.commit();
	}

	public boolean isAlreadyRegistered() {
		return mSharedPreferences.getBoolean(KEY_ALREADY_REGISTERED, false);
	}

	public void setAlreadyRegistered(boolean registered) {
		mPreferencesEditor.putBoolean(KEY_ALREADY_REGISTERED, registered);
		mPreferencesEditor.commit();
	}

	public int getUsersLevel() {
		return mSharedPreferences.getInt(KEY_USERS_LEVEL, 0);
	}

	public void setUsersLevel(int level) {
		mPreferencesEditor.putInt(KEY_USERS_LEVEL, level);
		mPreferencesEditor.commit();
	}
}
