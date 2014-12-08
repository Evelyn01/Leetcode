package com.leetcode.symmetrictree;

import com.leetcode.common.TreeNode;
import com.leetcode.common.TreeNodeCreator;

/**
 * Created by bod on 9/7/14.
 * https://oj.leetcode.com/problems/symmetric-tree/
 */
public class SymmetricTree {

    public static void main(String[] strings) {
        TreeNode root = TreeNodeCreator.createTreeNode("1, 2, 2, 3, 5, 4, 3");
        SymmetricTree symmetricTree = new SymmetricTree();
        System.out.println(symmetricTree.isSymmetric(root));
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        else return areSymSubtrees(root.left, root.right);
    }

    public boolean areSymSubtrees(TreeNode left, TreeNode right) {
        if (left == null || right == null) return ((left == null) && (right == null));
        return left.val == right.val && areSymSubtrees(left.left, right.right) && areSymSubtrees(left.right, right.left);
    }
}
