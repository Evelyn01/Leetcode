package com.leetcode.graycode;

import java.util.ArrayList;

/**
 * Created by titan-developer on 11/11/14.
 * https://oj.leetcode.com/problems/gray-code/
 */
public class GrayCode {

    public static void main(String[] strings) {
        GrayCode grayCode = new GrayCode();

        ArrayList<Integer> list = grayCode.grayCode(4);
        for (int i : list) {
            System.out.println(Integer.toBinaryString(i));
        }
    }

    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(0);
        for (int i = 0; i < n; i++) {
            int inc = 1 << i;
            for (int j = arr.size() - 1; j >= 0; j--) {
                arr.add(arr.get(j) + inc);
            }
        }
        return arr;
    }
}
