package com.leetcode.covertarraytosorted;

/**
 * Created by bod on 11/30/2014.
 * http://stackoverflow.com/questions/8928061/convert-array-to-a-sorted-one-using-only-two-operations
 */
public class ConvertArrayToSorted {

    public static void main(String[] strings) {
        int[] arrA = {4, 3, 5, 6};
        int[] arrB = {10, 3, 11, 12};

        ConvertArrayToSorted convertArrayToSorted = new ConvertArrayToSorted();
        System.out.println(convertArrayToSorted.getNumOfOp(arrA));
        System.out.println(convertArrayToSorted.getNumOfOp(arrB));
    }

    public int getNumOfOp(int[] arr) {

        int size = arr.length;
        int max = 0;
        for (int i = 0; i < size; i++) max = (arr[i] > max) ? arr[i] : max;
        int[][] dp = new int[size][max + 1];

        for (int j = 0; j <= max; j++) {
            if (arr[size - 1] >= j)
                dp[size - 1][j] = 0;
            else
                dp[size - 1][j] = arr[size - 1];
        }

        for (int i = size - 2; i > 0; i--) {
            for (int j = 0; j <= max; j++) {
                int minn = arr[i] + dp[i + 1][j]; //case where the element is deleted altogether

                if (j <= arr[i]) {
                    for (int k = j; k <= arr[i]; k++) {//we try decrementing to all possible values
                        minn = Math.min(minn, arr[i] - k + dp[i + 1][k]);
                    }
                }
                dp[i][j] = minn;
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= arr[0]; i++)
            ans = Math.min(ans, (arr[0] - i) + dp[1][i]);

        return ans;
    }
}
