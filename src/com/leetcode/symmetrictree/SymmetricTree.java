package com.leetcode.symmetrictree;

import com.leetcode.common.TreeNode;

/**
 * Created by bod on 9/7/14.
 * https://oj.leetcode.com/problems/symmetric-tree/
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        else return areSymSubtrees(root.left, root.right);
    }

    public boolean areSymSubtrees(TreeNode node1, TreeNode node2) {
        if (node1 == null || node2 == null) return ((node1 == null) && (node2 == null));
        if (node1.val != node2.val) return false;
        boolean outsideSym = areSymSubtrees(node1.left, node2.right);
        boolean insideSym = areSymSubtrees(node1.right, node2.left);
        return outsideSym && insideSym;
    }
}
