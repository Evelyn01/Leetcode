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
