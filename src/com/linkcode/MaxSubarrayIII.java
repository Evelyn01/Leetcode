package com.linkcode;

import java.util.*;

/**
 * Created by titan-developer on 12/11/14.
 */
public class MaxSubarrayIII {

    public static void main(String[] strings) {
        int[] a = {-1, 4, -2, 3, -2, 3};
        MaxSubarrayIII maxSubarrayIII = new MaxSubarrayIII();
        System.out.println(maxSubarrayIII.maxKSubArrays(a, 2));
    }

    public int maxKSubArrays(int[] nums, int k) {
        int[][] maxs = new int[nums.length][nums.length];

        for (int i = 0; i < nums.length; ++i) {
            int max_till = nums[i];
            maxs[i][i] = nums[i];
            for (int j = i + 1; j < nums.length; ++j) {
                max_till = Math.max(nums[j], max_till + nums[j]);
                maxs[i][j] = Math.max(maxs[i][j - 1], max_till);
            }
        }

        int[] dp = maxs[0];
        for (int m = 1; m < k; ++m) {
            int[] pre = new int[dp.length];
            for (int i = m; i < nums.length; ++i) {
                int max_i = Integer.MIN_VALUE;
                for (int j = m - 1; j < i; ++j) {
                    max_i = Math.max(max_i, dp[j] + maxs[j + 1][i]);
                }
                pre[i] = max_i;
            }
            dp = pre;
        }
        return dp[dp.length - 1];
    }
}
