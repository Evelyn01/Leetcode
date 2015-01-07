package com.practise1;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by titan-developer on 12/29/14.
 */
public class TestPractise {

    public static void main(String[] strings) {

        int[] a = {1, 2, 3};
        List list = Arrays.asList(a);

        TestPractise testPractise = new TestPractise();
        List<List<Integer>> ret = testPractise.permute(new int[]{1, 2, 3});
        outputList(ret);
    }

    public static <E> void outputList(List<E> list) {
        for (E elem : list) {
            System.out.print(elem + ", ");
        }
        System.out.println();
    }

    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (num == null || num.length == 0) return ret;
        if (num.length == 1) {
            List<Integer> list = Arrays.asList(num[0]);
            ret.add(list);
            return ret;
        }
        Arrays.sort(num);
        addToList(ret, num);
        while(next(num)) {
            addToList(ret, num);
        }
        return ret;
    }

    void addToList(List<List<Integer>> ret, int[] a) {
        List<Integer> list = new ArrayList<Integer>();
        for (int v : a) {
            list.add(v);
        }
        ret.add(list);
    }

    boolean next(int[] a) {
        int i = a.length - 2;
        while (i >= 0) {
            if (a[i] < a[i + 1]) {
                findAndSwap(a, i + 1, i);
                reverse(a, i + 1, a.length - 1);
                return true;
            }
            i --;
        }
        return false;
    }

    void findAndSwap(int[] a, int index, int target) {
        for (int i = a.length - 1; i >= index; i --) {
            if (a[i] > a[target]) {
                int tmp = a[target];
                a[target] = a[i];
                a[i] = tmp;
                break;
            }
        }
    }

    void reverse(int[] a, int from, int to) {
        while(from < to) {
            int tmp = a[to];
            a[to] = a[from];
            a[from] = tmp;
            from ++;
            to --;
        }
    }


    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length <= 1) return;

        int n = matrix.length;

        for (int i = 0; i < n / 2; i ++) {
            for (int j = i; j < n - i - 1; j ++) {

            }
        }
    }
}
