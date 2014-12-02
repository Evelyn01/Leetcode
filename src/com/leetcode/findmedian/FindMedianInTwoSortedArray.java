package com.leetcode.findmedian;

import java.util.ArrayList;

/**
 * Created by bod on 9/9/14.
 * https://oj.leetcode.com/problems/median-of-two-sorted-arrays/
 */
public class FindMedianInTwoSortedArray {


    public double findMedianSortedArrays(int A[], int B[]) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int m = A.length - 1;
        int n = B.length - 1;
        while (m >= 0 && n >= 0) {
            if (A[m] > B[n]) {
                list.add(A[m--]);
            } else {
                list.add(B[n--]);
            }
        }
        while (m >= 0) {
            list.add(A[m--]);
        }
        while (n >= 0) {
            list.add(B[n--]);
        }
        return (list.get(list.size() >> 1) + list.get((list.size() - 1) >> 1)) / 2.0;
    }
}
