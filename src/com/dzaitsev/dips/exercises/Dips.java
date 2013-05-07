package com.dzaitsev.dips.exercises;

/**
 * ------------------------ DESCRIPTION ------------------------<br>
 * <br>
 * Created by Dmitriy Zaitsev at 2013-04-29, 15:32.<br>
 */
public final class Dips extends Exercise {
	public Dips(final int level) {
		super(level);
		mMaxLevel = 16;
		mMaxSet = 5;

		if (level <= MIN_LEVEL) {
			mLevel = MIN_LEVEL;
		} else if (mMaxLevel < level) {
			mLevel = mMaxLevel;
		} else {
			mLevel = level;
		}

		reset();
	}

	/**
	 * @param initDips your initial dips
	 *
	 * @return -1 if you're too frail<br>
	 *         1 if you're too cool<br>
	 *         0 if you're OK :)
	 */
	public static int recommend(final int initDips) {
		if (initDips < DipsSet.MIN_DIPS) {
			return -1;
		} else if (DipsSet.MIN_DIPS <= initDips && initDips < DipsSet.MAX_DIPS) {
			return 0;
		} else {
			return 1;
		}
	}

	/** @return level which depends on dips */
	public static int calcLevel(final int dips) {
		for (int i = DipsSet.MIN_LEVEL; i < DipsSet.MAX_LEVEL; i++) {
			if (DipsSet.getSet1()[i - 1] <= dips && dips < DipsSet.getSet1()[i]) {
				return i;
			}
		}
		return 0;
	}

	/**
	 * @param number number of set
	 *
	 * @return amount of exercises of set
	 */
	public int getSet(final int number) {
		if (number <= 1) {
			return DipsSet.getSet1()[mLevel - 1];
		}

		switch (number) {
			case 2:
				return DipsSet.getSet2()[mLevel - 1];
			case 3:
				return DipsSet.getSet3()[mLevel - 1];
			case 4:
				return DipsSet.getSet4()[mLevel - 1];
			default:
				return DipsSet.getSet5()[mLevel - 1];
		}
	}
}
