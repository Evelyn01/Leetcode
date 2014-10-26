package com.leetcode.firstmissingpositive;

import java.util.HashMap;

/**
 * Created by titan-developer on 10/25/14.
 */
public class FirstMissingPositive {

    public static void main(String[] strings) {
        int[] a = {1, 2, 0};
        int[] b = {3, 4, -1, 1};
        int[] c = {1, 1};

        FirstMissingPositive missingPositive = new FirstMissingPositive();
        System.out.println(missingPositive.firstMissingPositive(a));
        System.out.println(missingPositive.firstMissingPositive(b));
        System.out.println(missingPositive.firstMissingPositive(c));
    }

    public int firstMissingPositive(int[] a) {
        if (a == null || a.length == 0) {
            return 1;
        }

        int missing = 1;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int value : a) {

            if (value > 0) {
                if (missing == value) {
                    missing ++;

                    while (map.containsKey(missing)) {
                        missing ++;
                    }

                } else if (value > missing) {
                    map.put(value, value);
                }
            }
        }

        return missing;
    }
}
