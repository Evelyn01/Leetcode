package com.practise1;

import com.leetcode.util.ListNode;
import com.leetcode.util.TreeNode;
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

        TestPractise testPractise = new TestPractise();
        outputTree(testPractise.generateTrees(0));
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

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> ret;
        if (n == 0) {
            ret = new ArrayList<TreeNode>();
            ret.add(null);
        } else {
            ret = helper(1, n);
        }
        return ret;
    }

    List<TreeNode> helper(int from, int to) {
        List<TreeNode> ret = new ArrayList<TreeNode>();

        if (from == to) {
            TreeNode root = new TreeNode(from);
            ret.add(root);
            return ret;
        }

        for (int left = 0; left < (to - from + 1); left ++) {
            int rootVal = from + left;
            List<TreeNode> leftList = null, rightList = null;
            int right = to - from - left;
            if (left > 0) {
                leftList = helper(from, from + left - 1);
            }
            if (right > 0) {
                rightList = helper(from + left + 1, to);
            }
            if (leftList == null) {
                leftList = new ArrayList<TreeNode>();
                leftList.add(null);
            }
            if (rightList == null) {
                rightList = new ArrayList<TreeNode>();
                rightList.add(null);
            }
            collect(leftList, rootVal, rightList, ret);
        }

        return ret;
    }

    void collect(List<TreeNode> leftList, int rootVal, List<TreeNode> rightList, List<TreeNode> ret) {
        for (int i = 0; i < leftList.size(); i ++) {
            for (int j = 0; j < rightList.size(); j ++) {
                TreeNode root = new TreeNode(rootVal);
                TreeNode leftNode = leftList.get(i);
                TreeNode rightNode = rightList.get(j);
                root.left = leftNode;
                root.right = rightNode;
                ret.add(root);
            }
        }
    }
}


