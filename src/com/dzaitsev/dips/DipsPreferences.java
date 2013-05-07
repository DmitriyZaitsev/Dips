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

	@Override public int getTrainingDay() {
		return mSharedPreferences.getInt(KEY_TRAINING_DAY, 0);
	}

	@Override public int getUserLevel() {
		return mSharedPreferences.getInt(KEY_USER_LEVEL, 0);
	}

	@Override public void setAlreadyRegistered(final boolean alreadyRegistered) {
		mPreferencesEditor.putBoolean(KEY_ALREADY_REGISTERED, alreadyRegistered);
		mPreferencesEditor.commit();
	}

	@Override public void setCurrentSet(final int currentSet) {
		mPreferencesEditor.putInt(KEY_CURRENT_SET, currentSet);
		mPreferencesEditor.commit();
	}

	@Override public void setDipsDone(final int dipsDone) {
		mPreferencesEditor.putInt(KEY_DIPS_DONE, dipsDone);
		mPreferencesEditor.commit();
	}

	@Override public void setDipsInitial(final int dipsInitial) {
		mPreferencesEditor.putInt(KEY_DIPS_INITIAL, dipsInitial);
		mPreferencesEditor.commit();
	}

	@Override public void setDipsTotal(final int dipsTotal) {
		mPreferencesEditor.putInt(KEY_DIPS_TOTAL, dipsTotal);
		mPreferencesEditor.commit();
	}

	@Override public void setTrainingDay(final int trainingDay) {
		mPreferencesEditor.putInt(KEY_TRAINING_DAY, trainingDay);
		mPreferencesEditor.commit();
	}

	@Override public void setUserLevel(final int userLevel) {
		if (userLevel >= 0) {
			mPreferencesEditor.putInt(KEY_USER_LEVEL, userLevel);
			mPreferencesEditor.commit();
		}
	}

	@Override public void setUserName(final String userName) {
		mPreferencesEditor.putString(KEY_USER_NAME, userName);
		mPreferencesEditor.commit();
	}
}
