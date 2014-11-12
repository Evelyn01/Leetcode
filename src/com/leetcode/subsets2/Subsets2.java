package com.leetcode.subsets2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by titan-developer on 11/11/14.
 * https://oj.leetcode.com/problems/subsets-ii/
 */
public class Subsets2 {

    public static void main(String[] strings) {


        int[] s = {1, 2, 2};

        Subsets2 subsets = new Subsets2();
        List<List<Integer>> lists = subsets.subsetsWithDup(s);

        for (List<Integer> list : lists) {
            for (int a : list) {
                System.out.print(a + ", ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] S) {
        Arrays.sort(S);

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        result.add(list);

        int oldval = S[0];
        int oldj = 0;
        for (int i = 0; i < S.length; i++) {
            int temp = oldj;
            if (S[i] != oldval) {
                oldval = S[i];
                temp = 0;
            }
            int j = result.size();
            oldj = j;
            while (j-- > temp) {
                //note temp here help avoid creating duplicate subsets
                ArrayList<Integer> newList = new ArrayList<Integer>(result.get(j));
                newList.add((S[i]));
                result.add(newList);
            }
        }
        return result;
    }
}
