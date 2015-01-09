package com.practise1;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by titan-developer on 12/29/14.
 */
public class TestPractise {

    public static void main(String[] strings) {

        int[][] a = {
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5},

        };

        TestPractise testPractise = new TestPractise();
        System.out.println(testPractise.minWindow("", ""));
    }

    public static <E> void outputList(List<E> list) {
        for (E elem : list) {
            System.out.print(elem + ", ");
        }
        System.out.println();
    }

    public String minWindow(String S, String T) {
        if (S == null || T == null || T.length() == 0) return "";
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        HashMap<Character, Integer> current = new HashMap<Character, Integer>();
        for (int i = 0; i < T.length(); i ++) {
            char c = T.charAt(i);
            int v = map.containsKey(c) ? map.get(c) : 0;
            map.put(c, v + 1);
        }
        int last = -1, count = 0;
        for (int i = 0; i < S.length(); i ++) {
            char c = S.charAt(i);
            if (map.containsKey(c)) {

            }
        }
        return "";
    }
}


