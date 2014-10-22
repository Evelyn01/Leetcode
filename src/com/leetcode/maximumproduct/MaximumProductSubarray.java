package com.leetcode.maximumproduct;

/**
 * Created by titan-developer on 10/22/14.
 * https://oj.leetcode.com/problems/maximum-product-subarray/
 */
public class MaximumProductSubarray {

    public static void main(String[] strings) {
        int[] a = {-3, -4};

        MaximumProductSubarray maxProduct = new MaximumProductSubarray();
        System.out.println(maxProduct.maxProduct(a));
    }

//    public int maxProduct2(int[] array) {
//        int maxProduct = Integer.MIN_VALUE;
//
//        if (array == null || array.length < 2) {
//            return maxProduct;
//        }
//
//        int minus = 0;
//
//        int current = 0;
//
//        for (int i = 0 ; i < array.length ; i ++) {
//            if (array[i])
//        }
//
//        return maxProduct;
//    }

    public int maxProduct(int[] array) {
        int maxProduct = Integer.MIN_VALUE;

        if (array == null || array.length < 2) {
            return maxProduct;
        }

        int minus = 0;
        maxProduct = array[0] * array[1];
        int maxLastIndex = 1;
        int currentMax = 0;

        for (int i = 2 ; i < array.length ; i ++) {
            if (maxProduct < 0) {
                minus = maxProduct;
                if (array[i] <= 0) {
                    maxProduct = maxProduct * array[i];
                    maxLastIndex = i;
                } else {
                    if (array[i - 1] > 0) {
                        maxProduct = array[i - 1] * array[i];
                        maxLastIndex = i;
                    } else {
                        minus = minus * array[i];
                    }
                }
            } else {
                if (maxLastIndex == i - 1) {
                    if (array[i] > 0) {
                        maxProduct = maxProduct * array[i];
                        maxLastIndex = i;
                    } else if (array[i] == 0) {
                        minus = 0;
                    } else {
                        minus = minus * array[i];
                    }
                } else {

                }


            }
        }

        return maxProduct;
    }
}
