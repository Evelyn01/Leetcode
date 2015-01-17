package com.practise1;

import com.leetcode.util.ListNode;
import com.leetcode.util.TreeNode;
import com.leetcode.util.TreeNodeCreator;
import com.leetcode.util.TreeNodePrinter;

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
                {'X', 'O', 'X'},
                {'O', 'X', 'O'},
                {'X', 'O', 'X'},
        };

        int[] gas = {1, 2};
        int[] cost = {2, 1};

        TestPractise testPractise = new TestPractise();
        System.out.println(testPractise.canCompleteCircuit(gas, cost));
        for (char[] arr : b) {
            System.out.println(arr);
        }
        System.out.println();
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

    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length == 0 || cost.length == 0 || gas.length != cost.length) return -1;
        int remain = 0, lastStart = -1, start = 0, len = gas.length;

        while (lastStart < start) {
            int i = 0;
            remain = 0;
            boolean isSucc = true;
            for (i = start; i <= start + len; i ++) {
                int index = i % len;
                if (remain + gas[index] < cost[index]) {
                    isSucc = false;
                    break;
                }
                remain += gas[index] - cost[index];
            }
            if (isSucc) return start;
            lastStart = start;
            start = (i + 1) % len;
        }

        return -1;
    }
}


