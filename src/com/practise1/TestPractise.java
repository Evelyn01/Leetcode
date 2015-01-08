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
        System.out.println(testPractise.getPermutation(1, 1));
    }

    public static <E> void outputList(List<E> list) {
        for (E elem : list) {
            System.out.print(elem + ", ");
        }
        System.out.println();
    }

    public String getPermutation(int n, int k) {
        if (n <= 0 || k <= 0) return "";
        int f = 1;
        k --;
        char[] arr = new char[n];
        for (int i = 0; i < n; i ++) {
            arr[i] = (char)('0' + i + 1);
            f *= i + 1;
        }
        for (int i = 0; i < n ; i ++) {
            f /= n - i;
            int index = k / f;
            char c = arr[i + index];
            System.arraycopy(arr, i, arr, i + 1, index);
            arr[i] = c;
            k %= f;
        }
        return new String(arr);
    }
}


