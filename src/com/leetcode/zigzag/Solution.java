package com.leetcode.zigzag;

public class Solution {

	public String convert(String s, int nRows) {
		if (nRows <= 0 || s == null || s.length() <= 0)
			return "";
		
		if (nRows == 1)
			return s;

		String[] convertArray = new String[nRows];
		for (int i = 0; i < nRows; i++) {
			convertArray[i] = "";
		}

		int currentRow = 0;

		int length = s.length();

		int index = 0;

		boolean isPlus = true;

		while (index < length) {
			convertArray[currentRow] += s.substring(index, index + 1);

			if (currentRow == nRows - 1) {
				isPlus = false;
			} else if (currentRow == 0) {
				isPlus = true;
			}

			if (isPlus)
				currentRow++;
			else
				currentRow--;

			index++;
		}

		String output = "";
		for (int i = 0; i < nRows; i++) {
			output += convertArray[i];
		}

		return output;
	}
}
