package com.linkcode;

import java.util.*;

/**
 * Created by titan-developer on 12/11/14.
 */
public class MaxSubarrayIII {

    public static void main(String[] strings) {
        int[] a = {-1, 4, -2, 3, -2, 3};
        MaxSubarrayIII maxSubarrayIII = new MaxSubarrayIII();

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < a.length; i++) {
            list.add(a[i]);
        }
        System.out.println(maxSubarrayIII.maxSubArray(list, 3));
    }

    public int maxSubArray(ArrayList<Integer> nums, int k) {
        int[] a = new int[nums.size()];
        for (int i = 0; i < nums.size(); i ++)
            a[i] = nums.get(i);

        if (k > a.length) {
            return 0;
        }

        int l = a.length;
        int[][][] dp = new int[l][l][k + 1];
        for (int i = 0; i < l; i ++) {
            int current = a[i];
            int max = a[i];
            dp[i][i][1] = a[i];
            for (int j = i + 1; j < l; j ++) {
                current = Math.max(current + a[j], a[j]);
                if (current > max) max = current;
                dp[i][j][1] = max;
            }
        }

        int count = 1;
        while (count < k) {
            count ++;

            for (int i = 0; i < l; i ++) {
                for (int j = i + count - 1; j < l; j ++) {
                    int span = 1;
                    int current;
                    int max = Integer.MIN_VALUE;
                    while (span < j - i + 1) {
                        current = dp[i][i + span - 1][1] + dp[i + span][j][count - 1];
                        if (current > max) max = current;
                        span ++;
                    }
                    dp[i][j][count] = max;
                }
            }
        }

        return dp[0][l - 1][k];
    }
}
