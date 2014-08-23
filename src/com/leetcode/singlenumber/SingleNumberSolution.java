package com.leetcode.singlenumber;

public class SingleNumberSolution {
	public int singleNumber(int[] A) {

		if (A == null || A.length < 1) {
			return 0;
		}

		int single = A[0];
		for (int i = 1; i < A.length; i++) {
			single ^= A[i];

		}
		return single;
	}
}