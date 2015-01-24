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

        int a0[] = {3, 4};
        int b0[] = {};

        int a1[] = {1, 3, 5, 7, 9};
        int b1[] = {6, 8, 10, 12, 14};

        int a2[] = {1, 1};
        int b2[] = {1, 1};

        int a3[] = {};
        int b3[] = {1, 2, 3, 4, 5};

        TestPractise testPractise = new TestPractise();
        int[] ret = testPractise.searchRange(new int[]{1, 1, 2}, 1);
        System.out.println(ret);
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

    public int[] searchRange(int[] A, int target) {
        int[] ret = new int[2];
        ret[0] = -1;
        ret[1] = -1;
        int left = 0, right = A.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (A[mid] == target) {
                if (mid == 0 || A[mid] != A[mid - 1]) {
                    ret[0] = mid;
                    ret[1] = mid;
                    left = mid;
                    break;
                } else {
                    right = mid - 1;
                }
            } else if (A[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        right = A.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (A[mid] == target) {
                if (mid == A.length - 1 || A[mid] != A[mid + 1]) {
                    ret[1] = mid;
                    break;
                } else {
                    left = mid + 1;
                }
            } else {
                right = mid - 1;
            }
        }
        return ret;
    }

}


