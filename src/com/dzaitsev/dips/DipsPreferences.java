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

	@Override public boolean isAlreadyRegistered() {
		return mSharedPreferences.getBoolean(KEY_ALREADY_REGISTERED, false);
	}

	@Override public int getUserLevel() {
		return mSharedPreferences.getInt(KEY_USER_LEVEL, 0);
	}

	@Override public void setAlreadyRegistered(final boolean alreadyRegistered) {
		mPreferencesEditor.putBoolean(KEY_ALREADY_REGISTERED, alreadyRegistered);
		mPreferencesEditor.commit();
	}

	@Override public void setDipsInitial(final int dipsInitial) {
		mPreferencesEditor.putInt(KEY_DIPS_INITIAL, dipsInitial);
		mPreferencesEditor.commit();
	}

	@Override public void setUserLevel(final int userLevel) {
		if (userLevel >= 0) {
			mPreferencesEditor.putInt(KEY_USER_LEVEL, userLevel);
			mPreferencesEditor.commit();
		}
	}
}
