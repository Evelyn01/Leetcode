package com.leetcode.binarytreetraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by titan-developer on 8/16/14.
 */
public class PreOrder {

    public static void main(String[] strings) {
        TreeNode root  = new TreeNode(1);

        root.right = new TreeNode(2);

        System.out.println("------------------");

        PreOrder preOrder = new PreOrder();
        List<Integer> list = preOrder.preorderTraversal(root);

        for(int val : list) {
            System.out.println(val);
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();

        //preOrderRecursive(list, root);

        preOrderIterative(list, root);

        return list;
    }

    void preOrderRecursive(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }

        list.add(root.val);
        preOrderRecursive(list, root.left);
        preOrderRecursive(list, root.right);
    }

    void preOrderIterative(List<Integer> list, TreeNode root) {

        TreeNode current = root;

        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (current != null) {
            list.add(current.val);

            if (current.left != null) {
                stack.push(current);
                current = current.left;
            } else if (current.right != null) {
                current = current.right;
            } else {
                if (stack.empty()) {
                    return;
                }

                TreeNode parent = stack.pop();

                while (parent.right == null) {
                    if (stack.empty())
                        return;

                    parent = stack.pop();
                }

                current = parent.right;
            }
        }

    }
}
