package com.dzaitsev.dips.exercises;

/**
 * ------------------------ DESCRIPTION ------------------------<br>
 * <br>
 * Created by Dmitriy Zaitsev at 2013-04-29, 15:32.<br>
 */
public final class Dips extends Exercise {
	public static final int MAX_LEVEL = 16;
	public static final int MAX_SET = 5;
	public static final int MIN_LEVEL = 1;
	public static final int MIN_SET = 1;

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

	/**
	 * @return number of total dips amount for five sets
	 *
	 * @see Exercise#getTotalExercises()
	 */
	@Override public int getTotalExercises() {
		return getSet1() + getSet2() + getSet3() + getSet4() + getSet5();
	}

	/** @see Exercise#confirmSet() */
	@Override public void confirmSet() {
		mCurrentSet++;

		if (mCurrentSet < MIN_SET) {
			mCurrentSet = MIN_SET;
		} else if (mCurrentSet > MAX_SET) {
			mCurrentSet = MAX_SET;
			mCurrentExercises = 0;
			return;
		}

		if (mCurrentSet == 1) {
			mCurrentExercises = getSet1();
		} else if (mCurrentSet == 2) {
			mCurrentExercises = getSet2();
		} else if (mCurrentSet == 3) {
			mCurrentExercises = getSet3();
		} else if (mCurrentSet == 4) {
			mCurrentExercises = getSet4();
		} else if (mCurrentSet == 5) {
			mCurrentExercises = getSet5();
		}
	}

	/**
	 * Sets values of current dips and current set to default
	 *
	 * @see Exercise#reset()
	 */
	@Override public void reset() {
		mCurrentSet = 1;
		mCurrentExercises = DipsSet.getSet1()[mLevel];
	}

	/** @return number of current dips necessary to do */
	public int getCurrentDips() {
		return mCurrentExercises;
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
		return DipsSet.getSet1()[mLevel];
	}

	/** @return number of dips from the second set */
	public int getSet2() {
		return DipsSet.getSet2()[mLevel];
	}

	/** @return number of dips from the third set */
	public int getSet3() {
		return DipsSet.getSet3()[mLevel];
	}

	/** @return number of dips from the fourth set */
	public int getSet4() {
		return DipsSet.getSet4()[mLevel];
	}

	/** @return number of dips from the fifth set */
	public int getSet5() {
		return DipsSet.getSet5()[mLevel];
	}
}
