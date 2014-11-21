package com.leetcode.pathsum;

import com.leetcode.common.TreeNode;
import com.leetcode.common.TreeNodeCreator;
import com.leetcode.common.TreeNodePrinter;

/**
 * Created by titan-developer on 11/9/14.
 * https://oj.leetcode.com/problems/path-sum/
 */
public class PathSum {

    public static void main(String[] strings) {
        TreeNode root = TreeNodeCreator.createTreeNode("10, 5, 15, #, #, 6, 20, 7");
        TreeNodePrinter.printNode(root);

        PathSum pathSum = new PathSum();
        System.out.println(pathSum.hasPathSum(root, 38));
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
