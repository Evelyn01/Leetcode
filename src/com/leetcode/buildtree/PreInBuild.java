package com.leetcode.buildtree;

import com.leetcode.common.TreeNode;

/**
 * Created by titan-developer on 9/6/14.
 * https://oj.leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class PreInBuild {

    static int[] preOrder = {1, 2, 3, 4, 5, 6};
    static int[] inOrder = {3, 2, 4, 1, 6, 5};

    public static void main(String[] strings) {
        PreInBuild build = new PreInBuild();
        TreeNode node = build.buildTree(preOrder, inOrder);
        System.out.println(node.val);
    }

    public TreeNode buildTreeNeat(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0; // Index of current root in inorder
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }
        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }

    //------------------------------------------------------------------------

    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        if (preOrder == null || preOrder.length == 0 || inOrder == null || inOrder.length == 0) {
            return null;
        }

        int root = preOrder[0];
        TreeNode rootNode = new TreeNode(root);

        int i;
        for (i = 0; i < inOrder.length; i++) {
            if (inOrder[i] == root) {
                break;
            }
        }

        int[] leftInOrder = null;
        int[] rightInOrder = null;
        int[] leftPreOrder = null;
        int[] rightPreOrder = null;
        if (i > 0) {
            leftInOrder = new int[i];
            System.arraycopy(inOrder, 0, leftInOrder, 0, i);

            leftPreOrder = new int[i];
            System.arraycopy(preOrder, 1, leftPreOrder, 0, leftPreOrder.length);
        }

        int rightLength = inOrder.length - i - 1;
        if (rightLength > 0) {
            rightInOrder = new int[rightLength];
            System.arraycopy(inOrder, i + 1, rightInOrder, 0, rightInOrder.length);

            rightPreOrder = new int[rightLength];
            System.arraycopy(preOrder, i + 1, rightPreOrder, 0, rightPreOrder.length);
        }

        rootNode.left = buildTree(leftPreOrder, leftInOrder);
        rootNode.right = buildTree(rightPreOrder, rightInOrder);

        return rootNode;
    }
}
