package com.leetcode.candy;

/**
 * Created by titan-developer on 8/19/14.
 */
public class CandySolution {

    public static void main(String[] strings) {

        int[] ratings = new int[] {2, 1, 5, 4, 7, 9 , 8, 3};

        CandySolution candySolution = new CandySolution();
        candySolution.candy(ratings);
    }

    public int candy(int[] ratings) {
        if (ratings == null) {
            return 0;
        }

        int[] candyArray = new int[ratings.length];

        for (int i = 0 ; i < ratings.length ; i ++) {
            candyArray[i] = 1;
            if (i > 0) {
                int temp = i;
                while (temp > 0) {
                    if (ratings[temp] > ratings[temp - 1]) {
                        if (candyArray[temp] <= candyArray[temp - 1]) {
                            candyArray[temp] = candyArray[temp - 1] + 1;
                        } else {
                            break;
                        }
                    } else if (ratings[temp] < ratings[temp - 1]) {
                        if (candyArray[temp] >= candyArray[temp - 1]) {
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
