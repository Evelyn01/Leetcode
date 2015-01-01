package com.practise1;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by titan-developer on 12/29/14.
 */
public class TestPractise {

    public static void main(String[] strings) {
        TestPractise testPractise = new TestPractise();
//        int[] a = {1, 2, 3, 5, 6, 7, 8};
//        int[] a = {1, 2, 3};
//        int[] a = {3, 2, 1};
        int[] a = {4, 2, 4, 4, 3};

        System.out.println(testPractise.longestValidParentheses("()(())"));
        System.out.println(Arrays.toString(a));
    }

    public static <E> void outputList(List<E> list) {
        for (E elem : list) {
            System.out.print(elem + ", ");
        }
        System.out.println();
    }

    public int longestValidParentheses(String s) {
        int ret = 0;
        if (s == null || s.length() == 0) return ret;
        Stack<Integer> stack = new Stack<Integer>();
        int[] a = new int[s.length()];
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (!stack.isEmpty()) {
                int index = stack.pop();
                a[index] = 1;
                a[i] = 1;
            }
        }

        int len = 0;
        for (int i = 0; i < a.length; i ++) {
            if (a[i] == 1) {
                len ++;
            } else {
                len = 0;
            }

            if (len > ret) ret = len;
        }

        return ret;
    }
}
