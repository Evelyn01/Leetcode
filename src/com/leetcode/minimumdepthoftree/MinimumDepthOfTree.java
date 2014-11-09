package com.leetcode.minimumdepthoftree;

import com.leetcode.common.TreeNode;

/**
 * Created by titan-developer on 11/9/14.
 */
public class MinimumDepthOfTree {

    public static void main(String[] strings) {
        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(5);
        root.right = new TreeNode(15);

        root.right.left = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.right = new TreeNode(20);

        MinimumDepthOfTree validBalanceTree = new MinimumDepthOfTree();
        System.out.println(validBalanceTree.minDepth(root));
    }

    public int minDepth(TreeNode root) {

        if( root == null ) return 0;

        if( root.left == null && root.right == null ) return 1;

        int a = minDepth( root.left );
        int b = minDepth( root.right );

        if( a > 0 && b > 0 ) return Math.min(a,b)+1;

        return a + b + 1;
    }
}
