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
