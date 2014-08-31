package com.leetcode.flattenbinarytree;

import com.leetcode.common.TreeNode;

/**
 * Created by bod on 8/31/14.
 * https://oj.leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
public class FlattenBinaryTree {

    public static void main(String[] strings) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.right = new TreeNode(6);

        FlattenBinaryTree flattenBinaryTree = new FlattenBinaryTree();
        flattenBinaryTree.flatten(root);
    }

    public void flatten(TreeNode root) {
        flattenTree(root);
    }

    public TreeNode flattenTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode leftTail = null;
        TreeNode left = root.left;
        if (left != null) {
            leftTail = flattenTree(left);
        }

        TreeNode rightTail = null;
        TreeNode right = root.right;
        if (right != null) {
            rightTail = flattenTree(right);
        }

        if (left != null && right != null) {
            root.left = null;
            root.right = left;
            leftTail.left = null;
            leftTail.right = right;
            return rightTail;
        } else if (left == null && right == null) {
            return root;
        } else if (left == null) {
            return rightTail;
        } else {
            root.left = null;
            root.right = left;
            return leftTail;
        }

    }
}
