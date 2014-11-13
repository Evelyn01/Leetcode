package com.leetcode.maxtreepathsum;

import com.leetcode.common.TreeNode;

/**
 * Created by titan-developer on 11/12/14.
 * https://oj.leetcode.com/problems/binary-tree-maximum-path-sum/
 */
public class MaxTreePathSum {

    public static void main(String[] strings) {
        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(5);
        root.right = new TreeNode(15);

        root.right.left = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.right = new TreeNode(20);

        MaxTreePathSum pathSum = new MaxTreePathSum();
        System.out.println(pathSum.maxPathSum(root));
    }

    int maxSum;

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        maxSum = root.val;
        recNodes(root);
        return maxSum;
    }

    int recNodes(TreeNode node) {
        int numl = 0, numr = 0;
        if (node.left != null)
            numl = recNodes(node.left);
        if (node.right != null)
            numr = recNodes(node.right);

        //choose the max path, either left or right
        int value = node.val;
        int sumWhole = checkMax(value, numl + numr);
        int sumLeft = numl > 0 ? checkMax(value, numl) : value;
        int sumRight = numr > 0 ? checkMax(value, numr) : value;

        return Math.max(sumLeft, sumRight);
    }

    int checkMax(int value, int sum) {
        if (sum > 0)
            sum += value;
        else
            sum = value;
        if (sum > maxSum)
            maxSum = sum;
        return sum;
    }


}