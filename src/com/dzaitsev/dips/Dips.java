package com.dzaitsev.dips;

/**
 * ------------------------ DESCRIPTION ------------------------<br>
 * <br>
 * Created by Dmitriy Zaitsev at 2013-04-29, 15:32.<br>
 */
public final class Dips {
	public static final int MAX_LEVEL = 16;
	public static final int MAX_SET = 5;
	public static final int MIN_LEVEL = 1;
	public static final int MIN_SET = 1;
	private int mCurrentDips;
	private int mCurrentSet;
	private int mDipsTotal;
	private int mLevel;

	public Dips(final int level) {
		if (level <= 0) {
			mLevel = 1;
		} else if (16 < level) {
			mLevel = 16;
		} else {
			mLevel = level;
		}
		reset();
	}

	/** @return number of current dips necessary to do */

	public int getCurrentDips() {
		return mCurrentDips;
	}

	/** @return number of current set */

	public int getCurrentSet() {
		if (mCurrentSet < MIN_SET) {
			return MIN_SET;
		}
		if (mCurrentSet > MAX_SET) {
			return MAX_SET;
		} else {
			return mCurrentSet;
		}
	}

	/** @return number of dips from the first set */

	public int getSet1() {
		return Sets.getSet1()[mLevel];
	}

	/** @return number of dips from the second set */

	public int getSet2() {
		return Sets.getSet2()[mLevel];
	}

	/** @return number of dips from the third set */

	public int getSet3() {
		return Sets.getSet3()[mLevel];
	}

	/** @return number of dips from the fourth set */

	public int getSet4() {
		return Sets.getSet4()[mLevel];
	}

	/** @return number of dips from the fifth set */

	public int getSet5() {
		return Sets.getSet5()[mLevel];
	}

	/** @return number of total dips amount for five sets */

	public int getTotalDips() {
		return getSet1() + getSet2() + getSet3() + getSet4() + getSet5();
	}

	/** Confirm that current set was successfully finished */

	public void confirmSet() {
		mCurrentSet++;

		if (mCurrentSet < MIN_SET) {
			mCurrentSet = MIN_SET;
		} else if (mCurrentSet > MAX_SET) {
			mCurrentSet = MAX_SET;
		}

		if (mCurrentSet == 1) {
			mCurrentDips = getSet1();
		} else if (mCurrentSet == 2) {
			mCurrentDips = getSet2();
		} else if (mCurrentSet == 3) {
			mCurrentDips = getSet3();
		} else if (mCurrentSet == 4) {
			mCurrentDips = getSet4();
		} else if (mCurrentSet == 5) {
			mCurrentDips = getSet5();
		}
	}

	/** Sets values of current dips and current set to default */

	public void reset() {
		mCurrentSet = 1;
		mCurrentDips = Sets.getSet1()[mLevel];
	}
}
