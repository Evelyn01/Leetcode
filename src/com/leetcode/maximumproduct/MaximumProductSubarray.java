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

    public int maxProduct(int[] array) {
        int maxProduct = Integer.MIN_VALUE;

        if (array == null || array.length < 2) {
            return maxProduct;
        }

        return maxProduct;
    }
}
