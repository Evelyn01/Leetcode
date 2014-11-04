package com.leetcode.dynamicprogramming;

/**
 * Created by bod on 8/26/14.
 * Maximum Value Contiguous Subsequence. Given a sequence of n real numbers A(1) ... A(n),
 * determine a contiguous subsequence A(i) ... A(j) for which the sum of elements in the subsequence is maximized.
 * <p/>
 */
public class MaxValueInSubSequence {

    static int[] a = {
            -1,
            0,
            -2,
            3,
            4,
            5,
            -1,
            -3,
            9,
            -2,
            8
    };

//    static int[] a = {
//            -2, 1, -3, 4, -1, 2, 1, -5, 4
//    };
//
//    static int[] a = {
//            -2, 1, -3, 4, -1, 2, 1, -5, 4
//    };

    public static void main(String[] strings) {
        MaxValueInSubSequence subSequence = new MaxValueInSubSequence();
        int value = subSequence.findMaxValue(a);
        System.out.println(value);
    }

    public int findMaxValue(int[] array) {
        if (array == null) {
            return Integer.MIN_VALUE;
        }

        int max = Integer.MIN_VALUE;

        int currentValue = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i ++) {
            if (array[i] < 0) {
                if (array[i] > max) {
                    max = array[i];
                } else if (currentValue > 0) {
                    currentValue += array[i];
                }
            } else {
                if (currentValue < 0) {
                    currentValue = array[i];
                } else {
                    currentValue += array[i];
                }
            }

            if (currentValue > max)  {
                max = currentValue;
            }
        }

        return max;
    }

    //incorrect DP.
    public int findMaxValueDP(int[] array) {
        if (array == null) {
            return Integer.MIN_VALUE;
        }

        if (array.length == 1) {
            return array[0];
        }

        int[] max = new int[array.length];

        max[0] = array[0];
        int minus = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > 0) {
                if (max[i - 1] <= 0) {
                    max[i] = array[i];
                    minus = 0;
                } else {
                    if (array[i] > -minus) {
                        max[i] = max[i - 1] + array[i] + minus;
                        minus = 0;
                    } else {
                        max[i] = max[i - 1];
                        minus += array[i];
                    }
                }
            } else if (array[i] < 0) {
                if (array[i] > max[i - 1]) {
                    max[i] = array[i];
                } else {
                    max[i] = max[i - 1];
                }
                minus += array[i];
            } else {
                if (max[i - 1] < 0) {
                    max[i] = 0;
                    minus = 0;
                } else {
                    max[i] = max[i - 1];
                }
            }
        }

        return max[array.length - 1];
    }
}
