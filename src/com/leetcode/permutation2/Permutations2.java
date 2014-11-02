package com.leetcode.permutation2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by titan-developer on 11/1/14.
 * https://oj.leetcode.com/problems/permutations-ii/
 */
public class Permutations2 {

    public static void main(String[] strings) {

        Permutations2 permutations = new Permutations2();

        List<List<Integer>> list = permutations.permuteUnique(new int[]{1, 2, 1, 2});

        for (List<Integer> array : list) {
            for (int a : array) {
                System.out.print(a + ", ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> permuteUnique(int[] num) {

        Arrays.sort(num);

        List<List<Integer>> list = new ArrayList<List<Integer>>();

        int l = num.length;

        addToList(list, num);

        int cursor = l - 1;

        while (cursor > 0) {
            if (num[cursor] > num[cursor - 1]) {
                swap(num, cursor);
                addToList(list, num);
                cursor = l - 1;
            } else {
                cursor--;
            }
        }

        return list;
    }

    private void swap(int[] pos, int cursor) {
        int a = pos[cursor - 1];
        int index = Integer.MAX_VALUE;
        int v = Integer.MAX_VALUE;
        for (int i = pos.length - 1, j = cursor; i >= j; i--, j++) {
            int tmp = pos[i];
            pos[i] = pos[j];
            pos[j] = tmp;

            if (pos[i] > a && pos[i] <= v) {
                if (i < index)
                    index = i;
                v = pos[i];
            }

            if (pos[j] > a && pos[j] <= v) {
                if (j < index)
                    index = j;
                v = pos[j];
            }
        }

        pos[cursor - 1] = pos[index];
        pos[index] = a;
    }

    private void addToList(List<List<Integer>> list, int[] num) {
        List<Integer> array = new ArrayList<Integer>();
        for (int i = 0; i < num.length; i++) {
            array.add(num[i]);
        }
        list.add(array);
    }
}
