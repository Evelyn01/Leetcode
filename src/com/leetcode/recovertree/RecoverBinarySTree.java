package com.leetcode.recovertree;

import com.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by titan-developer on 10/31/14.
 * https://oj.leetcode.com/problems/recover-binary-search-tree/
 */
public class RecoverBinarySTree {

    public static void main(String[] strings) {
        TreeNode root = createTree2();

        RecoverBinarySTree recover = new RecoverBinarySTree();
        recover.recoverTree(root);
    }

    private static TreeNode createTree() {
        TreeNode root_10 = new TreeNode(10);
        TreeNode node_7 = new TreeNode(7);
        TreeNode node_3 = new TreeNode(3);
        TreeNode node_4 = new TreeNode(4);
        TreeNode node_5 = new TreeNode(5);
        TreeNode node_6 = new TreeNode(6);
        TreeNode node_11 = new TreeNode(11);
        TreeNode node_13 = new TreeNode(13);
        TreeNode node_15 = new TreeNode(15);
        TreeNode node_14 = new TreeNode(14);
        TreeNode node_17 = new TreeNode(17);
        TreeNode node_19 = new TreeNode(19);

        root_10.left = node_7;
        root_10.right = node_15;

        node_7.left = node_13;

        node_13.left = node_3;
        node_13.right = node_5;

        node_5.right = node_6;

        node_15.left = node_4;
        node_15.right = node_17;

        node_4.left = node_11;
        node_4.right = node_14;

        node_17.right = node_19;


        return root_10;
    }

    private static TreeNode createTree2() {
        TreeNode root_10 = new TreeNode(10);
        TreeNode node_7 = new TreeNode(7);
        TreeNode node_3 = new TreeNode(3);
        TreeNode node_4 = new TreeNode(4);
        TreeNode node_5 = new TreeNode(5);
        TreeNode node_6 = new TreeNode(6);
        TreeNode node_11 = new TreeNode(11);
        TreeNode node_13 = new TreeNode(13);
        TreeNode node_15 = new TreeNode(15);
        TreeNode node_14 = new TreeNode(14);
        TreeNode node_17 = new TreeNode(17);
        TreeNode node_19 = new TreeNode(19);

        node_11.left = node_7;
        node_11.right = node_15;

        node_7.left = node_4;

        node_4.left = node_3;
        node_4.right = node_5;

        node_5.right = node_6;

        node_15.left = node_13;
        node_15.right = node_17;

        node_13.left = root_10;
        node_13.right = node_14;

        node_17.right = node_19;


        return node_11;
    }

    public void recoverTree(TreeNode root) {
        TreeNode[] lastNodes = new TreeNode[1];
        TreeNode[] swapNodes = new TreeNode[1];

        recoverTraversal(root, lastNodes, swapNodes);

        List<TreeNode> list = new ArrayList<TreeNode>();
        middleTraversal(root, list);

        for (TreeNode node : list) {
            System.out.print(node.val + ", ");
        }
    }

    private void middleTraversal(TreeNode root, List<TreeNode> list) {
        if (root.left != null) {
            middleTraversal(root.left, list);
        }

        list.add(root);

        if (root.right != null) {
            middleTraversal(root.right, list);
        }
    }

    private boolean recoverTraversal(TreeNode root, TreeNode[] lastNodes, TreeNode[] swapNodes) {
        boolean isSwapped = false;
        if (root.left != null) {
            isSwapped = recoverTraversal(root.left, lastNodes, swapNodes);
            if (isSwapped) {
                return true;
            }
        }

        if (swapNodes[0] != null) {
            if (swapNodes[0].val <= root.val) {
                TreeNode second = lastNodes[0];

                int val = swapNodes[0].val;
                swapNodes[0].val = second.val;
                second.val = val;

                return true;
            }
        } else if (lastNodes[0] != null) {
            if (root.val < lastNodes[0].val) {
                swapNodes[0] = lastNodes[0];
            }
        }
        lastNodes[0] = root;

        if (root.right != null) {
            isSwapped = recoverTraversal(root.right, lastNodes, swapNodes);
            if (isSwapped) {
                return isSwapped;
            }
        }

        return isSwapped;
    }

    private void findBrokenNodes(TreeNode root, List<TreeNode> brokenList) {
        if (brokenList.size() == 4) {
            return;
        }

        if (root.left != null) {
            findBrokenNodes(root.left, brokenList);
            if (root.left.val > root.val) {

            }
        }

        if (root.right != null) {
            findBrokenNodes(root.right, brokenList);
        }
    }

    private void swapNodes(TreeNode a_parent, TreeNode a, TreeNode b_parent, TreeNode b) {
        if (a_parent != null) {
            if (a_parent.right == a) {
                a_parent.right = b;
            } else {
                a_parent.left = b;
            }
        }

        if (b_parent != null) {
            if (b_parent.right == b) {
                b_parent.right = a;
            } else {
                b_parent.left = a;
            }
        }

        TreeNode temp = a.left;
        a.left = b.left;
        b.left = temp;

        temp = a.right;
        a.right = b.right;
        b.right = temp;
    }
}
