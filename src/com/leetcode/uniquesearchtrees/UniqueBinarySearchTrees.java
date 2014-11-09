package com.leetcode.uniquesearchtrees;

/**
 * Created by titan-developer on 11/9/14.
 */
public class UniqueBinarySearchTrees {

    public static void main(String[] strings) {
        UniqueBinarySearchTrees uniqueTrees = new UniqueBinarySearchTrees();
        System.out.println(uniqueTrees.numTrees(3));
    }

    public int numTrees(int n) {
        if (n == 0)
            return 0;
        else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }

        int[] dp = new int[n + 1];

        dp[0] = dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            for (int left = 0; left < i; left ++) {
                dp[i] += dp[left] * dp[i - left - 1];
            }
        }

        return dp[n];
    }
}
