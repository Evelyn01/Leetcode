package com.leetcode.symmetrictree;

import com.leetcode.common.TreeNode;

import java.util.ArrayList;

/**
 * Created by titan-developer on 9/6/14.
 * https://oj.leetcode.com/problems/symmetric-tree/
 */
public class SymmetricTreeWrongSolution {
    ArrayList<String> nodeArr;

    public static void main(String[] strings) {
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(3);
//
//        root.right = new TreeNode(2);
//        root.right.left = new TreeNode(3);
//        root.right.right = new TreeNode(4);

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.right = new TreeNode(1);
        root.left.right.left = new TreeNode(2);

        root.right = new TreeNode(1);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(2);

        SymmetricTreeWrongSolution tree = new SymmetricTreeWrongSolution();

        System.out.println(tree.isSymmetric(root));
    }

    public boolean isSymmetric(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) {
            return true;
        }
        nodeArr = new ArrayList<String>();
        inorderTraversal(root);

        // compare in-order traversal list
        int i = 0;
        int j = nodeArr.size() - 1;
        while (i < j) {
            if (!nodeArr.get(i).equals(nodeArr.get(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public void inorderTraversal(TreeNode n) {
        // if empty node, save as ‘#’ to occupy this place
        if (n == null) {
            nodeArr.add("#");
            return;
        }
        if (n.left == null && n.right == null) {
            nodeArr.add("" + n.val);
        } else {
            inorderTraversal(n.left);
            nodeArr.add("" + n.val);
            inorderTraversal(n.right);
        }
    }
}
