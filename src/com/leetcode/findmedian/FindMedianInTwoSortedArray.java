package com.leetcode.findmedian;

import java.util.ArrayList;

/**
 * Created by bod on 9/9/14.
 * https://oj.leetcode.com/problems/median-of-two-sorted-arrays/
 */
public class FindMedianInTwoSortedArray {

    public static void main(String[] strings) {

        int a[] = {1, 1};
        int b[] = {1, 2};

        FindMedianInTwoSortedArray findMedianInTwoSortedArray = new FindMedianInTwoSortedArray();

        System.out.println(findMedianInTwoSortedArray.findMedianSortedArraysMerge(a, b));
    }

    public double findMedianSortedArraysMerge(int a[], int b[]) {
        if (a == null && b == null) {
            return -1.0;
        }

        if (a == null) {
            a = new int[0];
        }

        if (b == null) {
            b = new int[0];
        }

        int index1 = (a.length + b.length - 1) / 2;
        int index2 = (a.length + b.length) / 2;

        int count = 0, i = 0, j = 0;
        int m1 = -1, m2 = -1, v;

        while (count <= index2) {

            if (j >= b.length || (i < a.length && a[i] < b[j])) {
                v = a[i];
                i ++;
            } else {
                v = b[j];
                j ++;
            }

            if (count == index1) {
                m1 = v;
            }

            if (count == index2) {
                m2 = v;
                break;
            }

            count ++;
        }

        return (double) (m1 + m2) / 2;
    }

    public double findMedianSortedArraysSlowest(int a[], int b[]) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int m = a.length - 1;
        int n = b.length - 1;
        while (m >= 0 && n >= 0) {
            if (a[m] > b[n]) {
                list.add(a[m--]);
            } else {
                list.add(b[n--]);
            }
        }
        while (m >= 0) {
            list.add(a[m--]);
        }
        while (n >= 0) {
            list.add(b[n--]);
        }
        return (list.get(list.size() >> 1) + list.get((list.size() - 1) >> 1)) / 2.0;
    }
}
