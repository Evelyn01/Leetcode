package com.practise1;

import com.leetcode.util.ListNode;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by titan-developer on 12/29/14.
 */
public class TestPractise {

    public static void main(String[] strings) {

        char[][] a = {
                {'0', '0', '0'},
                {'0', '0', '0'},
                {'0', '0', '0'},

        };

        char[][] b = {
                {'a'},
        };

        TestPractise testPractise = new TestPractise();
        outputList(testPractise.grayCode(3));
        System.out.println();
    }

    public static <E> void outputList(List<E> list) {
        for (E elem : list) {
            System.out.print(elem + ", ");
        }
        System.out.println();
    }

    public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<Integer>();
        if (n <= 0) return ret;
        ret.add(0);
        boolean[] set = new boolean[1 << n];
        set[0] = true;
        int count = 1, current = 0;
        while (count < set.length) {
            for (int i = 0; i < n; i ++) {
                int mask = 1 << i;
                int v = current ^ mask;
                if (!set[v]) {
                    set[v] = true;
                    count ++;
                    current = v;
                    ret.add(v);
                    break;
                }
            }
        }
        return ret;
    }
}


