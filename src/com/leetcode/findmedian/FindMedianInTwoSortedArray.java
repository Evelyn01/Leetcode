package com.leetcode.findmedian;

import com.leetcode.FindKthSmallest.FindKthSmallest;

import java.util.ArrayList;

/**
 * Created by bod on 9/9/14.
 * https://oj.leetcode.com/problems/median-of-two-sorted-arrays/
 * http://www.geeksforgeeks.org/median-of-two-sorted-arrays/
 */
public class FindMedianInTwoSortedArray {

    public static void main(String[] strings) {

        int a[] = {1, 1, 3, 5, 9, 11};
        int b[] = {1, 2, 4, 6, 8, 12};

        FindMedianInTwoSortedArray findMedianInTwoSortedArray = new FindMedianInTwoSortedArray();

        System.out.println(findMedianInTwoSortedArray.findMedianSortedArraysKth(a, b));
    }




    //------------------------------------------------------------------------------------------

    //call find kth
    public double findMedianSortedArraysKth(int a[], int b[]) {
        int m = a.length;
        int n = b.length;

        FindKthInTwoSortedArray findKthInTwoSortedArray  = new FindKthInTwoSortedArray();

        if ((m + n) % 2 == 1) {
            return findKthInTwoSortedArray.kthSmallest(a, b, (m + n) / 2);
        } else {
            return (findKthInTwoSortedArray.kthSmallest(a, b, (m + n) / 2) + findKthInTwoSortedArray.kthSmallest(a, b, (m + n) / 2 + 1)) * 0.5;
        }
    }

    //compare middle value

    public double findMedianSortedArrays(int A[], int B[]) {
        int lengthA = A.length;
        int lengthB = B.length;
        if ((lengthA + lengthB) % 2 == 0) {
            double r1 = (double) findMedianSortedArrays(A, 0, lengthA, B, 0, lengthB, (lengthA + lengthB) / 2);
            double r2 = (double) findMedianSortedArrays(A, 0, lengthA, B, 0, lengthB, (lengthA + lengthB) / 2 + 1);
            return (r1 + r2) / 2;
        } else
            return findMedianSortedArrays(A, 0, lengthA, B, 0, lengthB, (lengthA + lengthB + 1) / 2);
    }

    public int findMedianSortedArrays(int A[], int startA, int endA, int B[], int startB, int endB, int k) {
        int n = endA - startA;
        int m = endB - startB;

        if (n <= 0)
            return B[startB + k - 1];
        if (m <= 0)
            return A[startA + k - 1];
        if (k == 1)
            return A[startA] < B[startB] ? A[startA] : B[startB];

        int midA = (startA + endA) / 2;
        int midB = (startB + endB) / 2;

        if (A[midA] <= B[midB]) {
            if (n / 2 + m / 2 + 1 >= k)
                return findMedianSortedArrays(A, startA, endA, B, startB, midB, k);
            else
                return findMedianSortedArrays(A, midA + 1, endA, B, startB, endB, k - n / 2 - 1);
        } else {
            if (n / 2 + m / 2 + 1 >= k)
                return findMedianSortedArrays(A, startA, midA, B, startB, endB, k);
            else
                return findMedianSortedArrays(A, startA, endA, B, midB + 1, endB, k - m / 2 - 1);

        }
    }

    //------------------------------------------------------------------------------------------


    public double findMedianSortedArraysC(int A[], int B[]) {
        int n = A.length;
        int m = B.length;
        // the following call is to make sure len(A) <= len(B).
        // yes, it calls itself, but at most once, shouldn't be
        // consider a recursive solution
        if (n > m)
            return findMedianSortedArraysC(B, A);

        // now, do binary search
        int k = (n + m - 1) / 2;
        int l = 0, r = Math.min(k, n); // r is n, NOT n-1, this is important!!
        while (l < r) {
            int midA = (l + r) / 2;
            int midB = k - midA;
            if (A[midA] < B[midB])
                l = midA + 1;
            else
                r = midA;
        }

        // after binary search, we almost get the median because it must be between
        // these 4 numbers: A[l-1], A[l], B[k-l], and B[k-l+1]

        // if (n+m) is odd, the median is the larger one between A[l-1] and B[k-l].
        // and there are some corner cases we need to take care of.
        int a = Math.max(l > 0 ? A[l - 1] : Integer.MIN_VALUE, k - l >= 0 ? B[k - l] : Integer.MIN_VALUE);
        if (((n + m) & 1) == 1)
            return (double) a;

        // if (n+m) is even, the median can be calculated by
        //      median = (max(A[l-1], B[k-l]) + min(A[l], B[k-l+1]) / 2.0
        // also, there are some corner cases to take care of.
        int b = Math.min(l < n ? A[l] : Integer.MAX_VALUE, k - l + 1 < m ? B[k - l + 1] : Integer.MAX_VALUE);
        return (a + b) / 2.0;
    }


    //---------------------------------------------------------------------------------------------------------------

    //O(n)
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

    //------------------------------------------------------------------------------------------

    //need additional space.
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
