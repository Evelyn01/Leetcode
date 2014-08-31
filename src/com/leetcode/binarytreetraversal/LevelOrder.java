package com.leetcode.binarytreetraversal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bod on 8/30/14.
 */
public class LevelOrder {

    public static void main(String[] strings) {
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.left.left = new TreeNode(8);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        LevelOrder order = new LevelOrder();
        List<List<Integer>> list = order.levelOrderBottom(root);

        for (List<Integer> intList : list) {
            for (int a : intList) {
                System.out.print(a + " , ");
            }
            System.out.println("");
        }
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
            for (int i = 0 ; i < lastLevelNumber ; i ++) {
                TreeNode tempNode = list.get(0);
                currentLevel.add(tempNode.val);

                if (tempNode.left != null) {
                    currentLevelNumber ++;
                    list.add(tempNode.left);
                }

                if (tempNode.right != null) {
                    currentLevelNumber ++;
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
