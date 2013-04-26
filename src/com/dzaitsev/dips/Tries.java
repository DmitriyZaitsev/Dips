package com.dzaitsev.dips;

/**
 * ------------------------ DESCRIPTION ------------------------<br>
 * <br>
 * Created by Dmitriy Zaitsev at 2013-04-25, 14:01.<br>
 */
public final class Tries {
	private static final int[] mTry1 = new int[] {10, 15, 20, 25, 30, 35, 40, 43, 45, 47, 50, 53,
			55, 60, 63, 65, 68
	};
	private static final int[] mTry2 = new int[] {5, 15, 20, 25, 30, 30, 35, 40, 40, 45, 45, 50, 50,
			55, 60, 60, 65
	};
	private static final int[] mTry3 = new int[] {5, 10, 15, 20, 25, 25, 25, 30, 35, 35, 35, 40, 40,
			40, 45, 45, 45
	};
	private static final int[] mTry4 = new int[] {3, 5, 15, 15, 20, 20, 25, 30, 35, 35, 35, 40, 40,
			40, 45, 45, 45
	};
	private static final int[] mTry5 = new int[] {2, 5, 10, 10, 15, 15, 15, 20, 25, 25, 30, 35, 35,
			35, 40, 40, 40
	};

	public static int[] getTry1() {
		return mTry1;
	}

	public static int[] getTry2() {
		return mTry2;
	}

	public static int[] getTry3() {
		return mTry3;
	}

	public static int[] getTry4() {
		return mTry4;
	}

	public static int[] getTry5() {
		return mTry5;
	}
}
