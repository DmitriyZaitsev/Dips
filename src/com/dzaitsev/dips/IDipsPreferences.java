package com.dzaitsev.dips;

/**
 * ------------------------ DESCRIPTION ------------------------<br>
 * <br>
 * Created by Dmitriy Zaitsev at 2013-04-29, 12:05.<br>
 */
public interface IDipsPreferences {
	String DIPS_PREFERENCES         = "dips_preferences";
	String KEY_ALREADY_REGISTERED   = "already_registered";
	String KEY_DIPS_INITIAL         = "dips_initial";
	String KEY_USER_LEVEL           = "user_level";

	/**
	 * @return <i>true</i> if user already registered
	 */
	boolean isAlreadyRegistered();

	int getUserLevel();

	void setAlreadyRegistered(final boolean alreadyRegistered);

	void setDipsInitial(final int dipsInitial);

	void setUserLevel(final int userLevel);
}
