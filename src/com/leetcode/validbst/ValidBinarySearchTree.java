package com.leetcode.validbst;

import com.leetcode.common.TreeNode;

import java.util.List;

/**
 * Created by titan-developer on 11/9/14.
 * https://oj.leetcode.com/problems/validate-binary-search-tree/
 */
public class ValidBinarySearchTree {

    public static void main(String[] strings) {

        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(5);
        root.right = new TreeNode(15);

//        root.left.left = new TreeNode(3);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(20);

        ValidBinarySearchTree validBinarySearchTree = new ValidBinarySearchTree();
        System.out.println(validBinarySearchTree.isValidBST(root));
    }

    public boolean isValidBST(TreeNode root) {
        int[] array = new int[1];
        array[0] = Integer.MIN_VALUE;

        return inOrderRecursive(array, root);
    }

    private boolean inOrderRecursive(int[] array, TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean isValid = inOrderRecursive(array, root.left);
        if (isValid) {
            if (root.val > array[0]) {
                array[0] = root.val;
            } else {
                return false;
            }

            isValid = inOrderRecursive(array, root.right);
        }
        return isValid;
    }
}
