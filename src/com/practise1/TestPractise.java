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
                {'a'},
        };

        TreeNode treeNode = TreeNodeCreator.createTreeNode("2, 3, 1");

        TestPractise testPractise = new TestPractise();
        testPractise.recoverTree(treeNode);
        TreeNodePrinter.printNode(treeNode);
        System.out.println();
    }

    public static <E> void outputList(List<E> list) {
        for (E elem : list) {
            System.out.print(elem + ", ");
        }
        System.out.println();
    }

    TreeNode first, second, last;
    public void recoverTree(TreeNode root) {
        inOrder(root);
        int v1 = first.val;
        first.val = second.val;
        second.val = v1;
    }

    void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        if (last == null) {
            last = root;
        } else {
            if (root.val < last.val) {
                if (first == null && second == null) {
                    first = last;
                    second = root;
                } else {
                    second = root;
                }
            }
            last = root;
        }
        inOrder(root.right);
    }
}


