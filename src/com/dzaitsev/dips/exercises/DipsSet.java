package com.dzaitsev.dips.exercises;

/**
 * ------------------------ DESCRIPTION ------------------------<br>
 * <br>
 * Created by Dmitriy Zaitsev at 2013-04-25, 14:01.<br>
 */
final class DipsSet {
	static final int MAX_DIPS = 68;
	static final int MAX_LEVEL = 17;
	static final int MIN_DIPS = 10;
	static final int MIN_LEVEL = 1;
	private static final int[] sSet1 = new int[] {MIN_DIPS, 15, 20, 25, 30, 35, 40, 43, 45, 47, 50,
			53, 55, 60, 63, 65, MAX_DIPS
	};
	private static final int[] sSet2 = new int[] {5, 15, 20, 25, 30, 30, 35, 40, 40, 45, 45, 50, 50,
			55, 60, 60, 65
	};
	private static final int[] sSet3 = new int[] {5, 10, 15, 20, 25, 25, 25, 30, 35, 35, 35, 40, 40,
			40, 45, 45, 45
	};
	private static final int[] sSet4 = new int[] {3, 5, 15, 15, 20, 20, 25, 30, 35, 35, 35, 40, 40,
			40, 45, 45, 45
	};
	private static final int[] sSet5 = new int[] {2, 5, 10, 10, 15, 15, 15, 20, 25, 25, 30, 35, 35,
			35, 40, 40, 40
	};

	public static int[] getSet1() {
		return sSet1;
	}

	public static int[] getSet2() {
		return sSet2;
	}

	public static int[] getSet3() {
		return sSet3;
	}

	public static int[] getSet4() {
		return sSet4;
	}

	public static int[] getSet5() {
		return sSet5;
	}
}
