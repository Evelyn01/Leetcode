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
        System.out.println(testPractise.candy(gas));
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

    public int candy(int[] rates) {
        if (rates == null) {
            return 0;
        }

        int[] candy = new int[rates.length];
        candy[0] = 1;
        for (int i = 1; i < rates.length; i ++) {
            if (rates[i] <= rates[i - 1]) {
                candy[i] = 1;

            } else {
                candy[i] = candy[i - 1] + 1;
            }
        }

        int ret = 0;
        for (int i = 0; i < candy.length; i ++) ret += candy[i];
        return ret;
    }
}


