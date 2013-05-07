package com.dzaitsev.dips.exercises;

/**
 * ------------------------ DESCRIPTION ------------------------<br>
 * <br>
 * Created by Dmitriy Zaitsev at 2013-04-29, 17:47.<br>
 */
public abstract class Exercise {
	protected static final int MIN_LEVEL = 1;
	protected static final int MIN_SET = 1;
	int mLevel;
	int mMaxLevel;
	int mMaxSet;
	private int mCompletedExercises;
	private int mCurrentExercises;
	private int mCurrentSet;

	Exercise() {}

	/**
	 * @param number number of set
	 *
	 * @return amount of exercises of set
	 */
	public abstract int getSet(final int number);

	/** @return number of completed exercises */
	public int getCompleted() {
		return mCompletedExercises;
	}

	/** @return number of current dips necessary to do */
	public int getCurrent() {
		return mCurrentExercises;
	}

	/** @return number of current set */
	public int getCurrentSet() {
		return mCurrentSet;
	}

	public int getRemaining() {
		return getTotal() - mCompletedExercises;
	}

	/** @return number of total exercises amount for all sets */
	public int getTotal() {
		int total = 0;

		for (int i = MIN_SET; i <= mMaxSet; i++) {
			total += getSet(i);
		}
		return total;
	}

	/** Confirm that current set was successfully finished */
	public void confirmSet() {
		mCompletedExercises += getSet(mCurrentSet);

		if (mCompletedExercises > getTotal()) {
			mCompletedExercises = getTotal();
		}

		mCurrentSet++;
		mCurrentExercises = getSet(mCurrentSet);

		if (mCurrentSet < MIN_SET) {
			mCurrentSet = MIN_SET;
		} else if (mCurrentSet > mMaxSet) {
			mCurrentSet = mMaxSet;
			mCurrentExercises = 0;
		}
	}

	/** Sets values of current exercise to default */
	public void reset() {
		mCurrentSet = MIN_SET;
		mCurrentExercises = getSet(1);
		mCompletedExercises = 0;
	}
}
