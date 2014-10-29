package com.leetcode.combinationsum;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by titan-developer on 10/28/14.
 */
public class CombinationSum {

    public static void main(String[] strings) {

        int a[] = {2, 3, 5, 6, 7, 9};

        CombinationSum sum = new CombinationSum();

        List<List<Integer>> solutions = sum.combinationSum(a, 12);

        for (List<Integer> solution : solutions) {
            for (Integer integer : solution) {
                System.out.print(integer + ", ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> solutions = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0 || target <= 0) {
            return solutions;
        }

        return solutions;
    }
}
