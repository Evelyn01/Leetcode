package com.leetcode.pathsum;

import com.leetcode.common.TreeNode;

/**
 * Created by titan-developer on 11/9/14.
 */
public class PathSum {

    public static void main(String[] strings) {
        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        TreeNode root = new TreeNode(10);
//
//        root.left = new TreeNode(5);
//        root.right = new TreeNode(15);
//
//        root.right.left = new TreeNode(6);
//        root.right.left.left = new TreeNode(7);
//        root.right.right = new TreeNode(20);


        PathSum pathSum = new PathSum();
        System.out.println(pathSum.hasPathSum(root, 1));
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        return dfs(root, sum);
    }

    private boolean dfs(TreeNode root, int sum) {
        if (root == null) {
            return sum == 0;
        }

        if (root.left == null && root.right == null && sum == root.val) {
            return true;
        }

        boolean isValid = false;
        if (root.left != null) {
            isValid = dfs(root.left, sum - root.val);
        }

        if (!isValid && root.right != null) {
            isValid = dfs(root.right, sum - root.val);
        }

        return isValid;
    }
}
