package com.leetcode.binarytreetraversal;

import com.leetcode.common.TreeNode;
import com.leetcode.common.TreeNodeCreator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bod on 8/30/14.
 * https://oj.leetcode.com/problems/binary-tree-level-order-traversal/
 * https://oj.leetcode.com/problems/binary-tree-level-order-traversal-ii/
 * https://oj.leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class LevelOrder {

    public static void main(String[] strings) {
        TreeNode root = TreeNodeCreator.createTreeNode("3, 9, 20, 8, #, 15, 7");

        LevelOrder order = new LevelOrder();
        outputList(order.levelOrder(root));
        outputList(order.levelOrderBottom(root));
        outputList(order.levelOrderZigZag(root));
    }

    public static void outputList(List<List<Integer>> list) {
        for (List<Integer> intList : list) {
            for (int a : intList) {
                System.out.print(a + " , ");
            }
            System.out.println("");
        }
        System.out.println("--------------");
    }

    public List<List<Integer>> levelOrderZigZag(TreeNode treeNode) {
        ArrayList<List<Integer>> order = new ArrayList<List<Integer>>();
        if (treeNode == null) {
            return order;
        }

        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        list.add(treeNode);

        int lastLevelNumber = 1;
        int currentLevelNumber = 0;
        boolean isRightOrder = false;
        while (list.size() > 0) {
            ArrayList<Integer> currentLevel = new ArrayList<Integer>();
            currentLevelNumber = 0;
            for (int i = 0; i < lastLevelNumber; i++) {
                TreeNode tempNode = list.get(0);

                if (isRightOrder)
                    currentLevel.add(0, tempNode.val);
                else
                    currentLevel.add(tempNode.val);

                if (tempNode.left != null) {
                    currentLevelNumber++;
                    list.add(tempNode.left);
                }

                if (tempNode.right != null) {
                    currentLevelNumber++;
                    list.add(tempNode.right);
                }
                list.remove(0);
            }
            lastLevelNumber = currentLevelNumber;
            order.add(currentLevel);
            isRightOrder = !isRightOrder;
        }


        return order;
    }

    public List<List<Integer>> levelOrder(TreeNode treeNode) {
        ArrayList<List<Integer>> order = new ArrayList<List<Integer>>();
        if (treeNode == null) {
            return order;
        }

        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        list.add(treeNode);

        int lastLevelNumber = 1;
        int currentLevelNumber = 0;
        while (list.size() > 0) {
            ArrayList<Integer> currentLevel = new ArrayList<Integer>();
            currentLevelNumber = 0;
            for (int i = 0; i < lastLevelNumber; i++) {
                TreeNode tempNode = list.get(0);
                currentLevel.add(tempNode.val);

                if (tempNode.left != null) {
                    currentLevelNumber++;
                    list.add(tempNode.left);
                }

                if (tempNode.right != null) {
                    currentLevelNumber++;
                    list.add(tempNode.right);
                }
                list.remove(0);
            }
            lastLevelNumber = currentLevelNumber;
            order.add(currentLevel);
        }


        return order;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode treeNode) {
        ArrayList<List<Integer>> order = new ArrayList<List<Integer>>();
        if (treeNode == null) {
            return order;
        }

        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        list.add(treeNode);

        int lastLevelNumber = 1;
        int currentLevelNumber = 0;
        while (list.size() > 0) {
            ArrayList<Integer> currentLevel = new ArrayList<Integer>();
            currentLevelNumber = 0;
            for (int i = 0; i < lastLevelNumber; i++) {
                TreeNode tempNode = list.get(0);
                currentLevel.add(tempNode.val);

                if (tempNode.left != null) {
                    currentLevelNumber++;
                    list.add(tempNode.left);
                }

                if (tempNode.right != null) {
                    currentLevelNumber++;
                    list.add(tempNode.right);
                }
                list.remove(0);
            }
            lastLevelNumber = currentLevelNumber;
            order.add(0, currentLevel);
        }


        return order;
    }
}
