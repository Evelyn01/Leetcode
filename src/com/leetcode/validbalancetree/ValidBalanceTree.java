package com.leetcode.validbalancetree;

import com.leetcode.common.TreeNode;

/**
 * Created by titan-developer on 11/9/14.
 * https://oj.leetcode.com/problems/balanced-binary-tree/
 */
public class ValidBalanceTree {

    public static void main(String[] strings) {
        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(5);
        root.right = new TreeNode(15);

        root.right.left = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.right = new TreeNode(20);

        ValidBalanceTree validBalanceTree = new ValidBalanceTree();
        System.out.println(validBalanceTree.isBalanced(root));
    }

    public boolean isBalanced(TreeNode root) {
        int height = getHeight(root);
        return height >= 0;
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftH = getHeight(root.left);
        if (leftH < 0) {
            return -1;
        }
        int rightH = getHeight(root.right);
        if (rightH < 0) {
            return -1;
        }

        if (Math.abs(leftH - rightH) <= 1) {
            return ( leftH > rightH ? leftH : rightH ) + 1;
        } else {
            return -1;
        }
    }
}
