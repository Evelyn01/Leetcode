package com.leetcode.roottoleaf;

import com.leetcode.common.TreeNode;

/**
 * Created by titan-developer on 11/9/14.
 */
public class RootToLeaf {

    public static void main(String[] strings) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.right.left = new TreeNode(4);
        root.right.left.left = new TreeNode(5);
        root.right.right = new TreeNode(3);

        RootToLeaf rootToLeaf = new RootToLeaf();
        System.out.println(rootToLeaf.sumNumbers(root));
    }

    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;

        int[] count = new int[2];
        dfs(root, count);

        return count[0];
    }

    private void dfs(TreeNode root, int[] count) {
        if (root.left == null && root.right == null) {
            count[1] = (count[1] * 10) + root.val;
            count[0] += count[1];
            count[1] = (count[1] - root.val) / 10;
            return;
        }

        count[1] = (count[1] * 10) + root.val;
        if (root.left != null) {
            dfs(root.left, count);
        }

        if (root.right != null) {
            dfs(root.right, count);
        }
        count[1] = (count[1] - root.val) / 10;
    }
}
