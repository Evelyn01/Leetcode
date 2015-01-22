package com.practise1;

import com.leetcode.util.ListNode;
import com.leetcode.util.TreeNode;
import com.leetcode.util.TreeNodePrinter;

import java.util.HashMap;
import java.util.Iterator;
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

        int ca = 5;

        int[] gas = {1, 2};
        int[] cost = {2, 1};

        Point[] points = new Point[3];
        points[0] = new Point(2, 3);

        points[1] = new Point(3, 3);

        points[2] = new Point(-5, 3);

        char[] buf = new char[100];
        ListNode head = ListNode.createList("2->3->1->6->5->7->4");
        TestPractise testPractise = new TestPractise();
//        System.out.println(testPractise.search(new int[]{3, 4, 5, 6, 1, 2}, 1));
//        System.out.println(testPractise.search(new int[]{3, 4, 5, 6, 1, 2}, 0));
//        System.out.println(testPractise.search(new int[]{3, 4, 5, 6, 1, 2}, 7));
        System.out.println(testPractise.findMin(new int[]{2, 3, 4, 1}));
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

    /**
     * Definition for a point.
     */
    static class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    public int findMin(int[] num) {
        if (num == null || num.length == 0) return Integer.MIN_VALUE;
        int l = 0, r = num.length - 1;
        if (num[l] <= num[r]) return num[l];
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (m > 0 && num[m] < num[m - 1]) return num[m];
            if (m < num.length - 1 && num[m] > num[m + 1]) return num[m + 1];
            if (num[l] <= num[m]) { //lower bound sorted
                l = m;
            } else {
                r = m;
            }
        }
        return num[num.length - 1];
    }
}


