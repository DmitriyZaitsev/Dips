package com.dzaitsev.dips;

/**
 * ------------------------ DESCRIPTION ------------------------<br>
 * <br>
 * Created by Dmitriy Zaitsev at 2013-04-25, 14:01.<br>
 */
public class Tries {
	private byte[] try1;
	private byte[] try2;
	private byte[] try3;
	private byte[] try4;
	private byte[] try5;

	public Tries() {
		try1 = new byte[] {10, 15, 20, 25, 30, 35, 40, 40, 45, 45, 50, 50, 55, 60, 60, 65, 65
		};
		try2 = new byte[] {5,  15, 20, 25, 30, 30, 35, 40, 40, 45, 45, 50, 50, 55, 60, 60, 65
		};
		try3 = new byte[] {5,  10, 15, 20, 25, 25, 25, 30, 35, 35, 35, 40, 40, 40, 45, 45, 45
		};
		try4 = new byte[] {3,  5,  15, 15, 20, 20, 25, 30, 35, 35, 35, 40, 40, 40, 45, 45, 45
		};
		try5 = new byte[] {2,  5,  10, 10, 15, 15, 15, 20, 25, 25, 30, 35, 35, 35, 40, 40, 40
		};
	}

	public byte[] getTry1() {
		return try1;
	}
	public byte[] getTry2() {
		return try2;
	}
	public byte[] getTry3() {
		return try3;
	}
	public byte[] getTry4() {
		return try4;
	}
	public byte[] getTry5() {
		return try5;
	}
}
