package com.dzaitsev.dips;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * ------------------------ DESCRIPTION ------------------------<br>
 * <br>
 * Created by Dmitriy Zaitsev at 2013-04-25, 16:13.<br>
 */
public final class DipsPreferences implements IDipsPreferences {

	private final SharedPreferences.Editor mPreferencesEditor;

	private final SharedPreferences mSharedPreferences;

	public DipsPreferences(Context context) {
		mSharedPreferences = context.getSharedPreferences(DIPS_PREFERENCES, Context.MODE_PRIVATE);
		mPreferencesEditor = mSharedPreferences.edit();
	}

	@Override public String getUserName() {
		return mSharedPreferences.getString(KEY_USER_NAME, "Unknown User");
	}

	@Override public boolean isAlreadyRegistered() {
		return mSharedPreferences.getBoolean(KEY_ALREADY_REGISTERED, false);
	}

	@Override public int getCurrentSet() {
		return mSharedPreferences.getInt(KEY_CURRENT_SET, 0);
	}

	@Override public int getDipsDone() {
		return mSharedPreferences.getInt(KEY_DIPS_DONE, 0);
	}

	@Override public int getDipsInitial() {
		return mSharedPreferences.getInt(KEY_DIPS_INITIAL, 0);
	}

	@Override public int getDipsTotal() {
		return mSharedPreferences.getInt(KEY_DIPS_TOTAL, 0);
	}

	@Override public int getUserLevel() {
		return mSharedPreferences.getInt(KEY_USER_LEVEL, 0);
	}

	@Override public void setAlreadyRegistered(boolean alreadyRegistered) {
		mPreferencesEditor.putBoolean(KEY_ALREADY_REGISTERED, alreadyRegistered);
		mPreferencesEditor.commit();
	}

	@Override public void setCurrentSet(final int currentSet) {
		//TODO: Implement DipsPreferences->setCurrentSet body
	}

	@Override public void setDipsDone(final int dipsDone) {
		//TODO: Implement DipsPreferences->setDipsDone body
	}

	@Override public void setDipsInitial(int dipsInitial) {
		mPreferencesEditor.putInt(KEY_DIPS_INITIAL, dipsInitial);
		mPreferencesEditor.commit();
	}

	@Override public void setDipsTotal(final int dipsTotal) {
		//TODO: Implement DipsPreferences->setDipsTotal body
	}

	@Override public void setUserName(String userName) {
		mPreferencesEditor.putString(KEY_USER_NAME, userName);
		mPreferencesEditor.commit();
	}

	@Override public void setUserLevel(int userLevel) {
		mPreferencesEditor.putInt(KEY_USER_LEVEL, userLevel);
		mPreferencesEditor.commit();
	}
}
