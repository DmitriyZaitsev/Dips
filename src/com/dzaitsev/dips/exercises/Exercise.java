package com.dzaitsev.dips.exercises;

/**
 * ------------------------ DESCRIPTION ------------------------<br>
 * <br>
 * Created by Dmitriy Zaitsev at 2013-04-29, 17:47.<br>
 */
public abstract class Exercise {
	public static final int MAX_LEVEL = 100;
	public static final int MAX_SET = 100;
	public static final int MIN_LEVEL = 1;
	public static final int MIN_SET = 1;
	protected int mCurrentExercises;
	protected int mCurrentSet;
	protected int mLevel;

	/** @return number of total com.dzaitsev.dips.exercises amount for all sets */
	public abstract int getTotalExercises();

	/** Confirm that current set was successfully finished */
	public abstract void confirmSet();

	/** Sets values of current exercise to default */
	public abstract void reset();
}
