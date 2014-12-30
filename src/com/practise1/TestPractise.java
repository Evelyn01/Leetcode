package com.practise1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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

        System.out.println(testPractise.trailingZeroes(23));
        System.out.println(Arrays.toString(a));
    }

    public static <E> void outputList(List<E> list) {
        for (E elem : list) {
            System.out.print(elem + ", ");
        }
        System.out.println();
    }

    public int trailingZeroes(int n) {
        int result = 0;
        for (int i = 5; n / i > 0; i *= 5) {
            result += (n / i);
        }
        return result;
    }
}
