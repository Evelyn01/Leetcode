package com.leetcode.binarytree;

import com.leetcode.sortlinkedlist.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by titan-developer on 8/16/14.
 */
public class PostOrder {

    public static void main(String[] strings) {
        TreeNode root  = new TreeNode(0);

        root.left = new TreeNode(1);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(8);

        root.left.right.left.left = new TreeNode(10);
        root.left.right.right.left = new TreeNode(9);

        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        PostOrder postOrder = new PostOrder();

        List<Integer> list = postOrder.postOrderTraversalRecursive(root);

        for(int val : list) {
            System.out.println(val);
        }

        System.out.println("------------------");

        PreOrder preOrder = new PreOrder();
        list = preOrder.preorderTraversal(root);

        for(int val : list) {
            System.out.println(val);
        }

        System.out.println("------------------");

        InOrder inOrder = new InOrder();
        list = inOrder.inOrderTraversalRecursive(root);

        for(int val : list) {
            System.out.println(val);
        }
    }

    public List<Integer> postOrderTraversalRecursive(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();

        postOrderRecursive(list, root);

        return list;
    }

    private void postOrderRecursive(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }

        postOrderRecursive(list, root.left);
        postOrderRecursive(list, root.right);
        list.add(root.val);
    }
}
