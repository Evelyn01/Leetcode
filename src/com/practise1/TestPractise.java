package com.practise1;

import com.leetcode.util.TreeNode;
import com.leetcode.util.TreeNodePrinter;

import java.util.List;

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
                {'X', 'O', 'X'},
                {'O', 'X', 'O'},
                {'X', 'O', 'X'},
        };

        int a1[] = {};
        int b1[] = {1, 2, 3, 4, 5};

        TestPractise testPractise = new TestPractise();
        System.out.println(testPractise.findMedianSortedArrays(a1, b1));
//        for (int i = 1; i <= a1.length + b1.length; i ++)
//            System.out.println(testPractise.findKth(a1, b1, i));
    }

    private static void outputTree(List<TreeNode> treeNodes) {
        for (TreeNode root : treeNodes) {
            TreeNodePrinter.printNode(root);
            System.out.println("------------------");
        }
    }

    public static <E> void outputList(List<E> list) {
        for (E elem : list) {
            System.out.print(elem + ", ");
        }
        System.out.println();
    }

    public double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length;
        int n = B.length;

        if ((m + n) % 2 == 0) {
            return (kthSmallest(A, B, (m + n) / 2) + kthSmallest(A, B, (m + n) / 2 + 1)) * 0.5;
        } else {
            return kthSmallest(A, B, (m + n) / 2 + 1) * 1.0;
        }
    }

    public int kthSmallest(int[] A, int[] B, int k) {
        if (A == null || B == null || k > A.length + B.length || k <= 0)
            throw new IllegalArgumentException();
        int aLow = 0, bLow = 0, aLen = A.length, bLen = B.length;

        while (aLen > 0 || bLen > 0) {
            int i = (int) ((double) ((k - 1) * aLen / (aLen + bLen)));
            int j = k - 1 - i;

            int Ai_1 = aLow + i == 0 ? Integer.MIN_VALUE : A[aLow + i - 1];
            int Ai = aLow + i == A.length ? Integer.MAX_VALUE : A[aLow + i];

            int Bj_1 = bLow + j == 0 ? Integer.MIN_VALUE : B[bLow + j - 1];
            int Bj = bLow + j == B.length ? Integer.MAX_VALUE : B[bLow + j];

            if (Bj_1 <= Ai && Ai <= Bj)
                return Ai;
            else if (Ai_1 <= Bj && Bj <= Ai)
                return Bj;

            if (Ai < Bj_1) {
                aLow = aLow + i + 1;
                aLen = aLen - i - 1;
                bLen = j;
                k = k - i - 1;
            } else {
                aLen = i;
                bLow = bLow + j + 1;
                bLen = bLen - j - 1;
                k = k - j - 1;
            }
        }

        return Integer.MIN_VALUE;
    }

}


