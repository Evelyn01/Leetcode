package com.leetcode.candy;

/**
 * Created by titan-developer on 8/19/14.
 */
public class Solution {
    public int candy(int[] ratings) {
        if (ratings == null) {
            return 0;
        }

        int[] candyArray = new int[ratings.length];

        for (int i = 0 ; i < ratings.length ; i ++) {
            candyArray[i] = 1;
            if (i > 0) {
                int temp = i;
                while (temp > 1) {
                    if (ratings[temp] > ratings[temp - 1]) {
                        if (candyArray[temp] <= candyArray[temp - 1]) {
                            candyArray[temp] = candyArray[temp - 1] + 1;
                        }
                        break;
                    } else if (ratings[temp] < ratings[temp - 1]) {
                        if (candyArray[temp] >= candyArray[i - 1]) {
                            candyArray[temp - 1] = candyArray[temp] + 1;
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                    temp --;
                }
            }
        }

        int total = 0;
        for(int i : candyArray) {
            total += i;
        }

        return total;
    }
}
