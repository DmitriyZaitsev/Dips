package com.dzaitsev.dips;

/**
 * ------------------------ DESCRIPTION ------------------------<br>
 * <br>
 * Created by Dmitriy Zaitsev at 2013-04-29, 12:05.<br>
 */
public interface IDipsPreferences {

	String DIPS_PREFERENCES         = "dips_preferences";
	String KEY_ALREADY_REGISTERED   = "already_registered";
	String KEY_CURRENT_SET          = "current_set";
	String KEY_DIPS_DONE            = "dips_done";
	String KEY_DIPS_INITIAL         = "dips_initial";
	String KEY_DIPS_TOTAL           = "dips_total";
	String KEY_USER_LEVEL           = "user_level";
	String KEY_USER_NAME            = "user_name";

	String getUserName();

	boolean isAlreadyRegistered();

	int getCurrentSet();

	int getDipsDone();

	int getDipsInitial();

	int getDipsTotal();

	int getUserLevel();

	void setAlreadyRegistered(final boolean alreadyRegistered);

	void setCurrentSet(final int currentSet);

	void setDipsDone(final int dipsDone);

	void setDipsInitial(final int dipsInitial);

	void setDipsTotal(final int dipsTotal);

	void setUserLevel(final int userLevel);

	void setUserName(final String userName);
}
