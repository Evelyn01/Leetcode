package com.practise1;

import com.leetcode.util.ListNode;
import com.leetcode.util.TreeNode;
import com.leetcode.util.TreeNodePrinter;

import java.util.List;

/**
 * Created by titan-developer on 12/29/14.
 */
public class TestPractise {

    public static void main(String[] strings) {

        char[][] a = {
                {'0', '0', '0'},
                {'0', '0', '0'},
                {'0', '0', '0'},

        };


        char[][] b = {
                {'X', 'O', 'X'},
                {'O', 'X', 'O'},
                {'X', 'O', 'X'},
        };

        int ca = 5;

        int[] gas = {1, 2};
        int[] cost = {2, 1};

        char[] buf = new char[100];
        ListNode head = ListNode.createList("2->3->1->6->5->7->4");
        TestPractise testPractise = new TestPractise();
        System.out.println(testPractise.validNumber(".9"));
        System.out.println(testPractise.validNumber(".e1"));
    }

    private static void outputTree(List<TreeNode> treeNodes) {
        for (TreeNode root : treeNodes) {
            TreeNodePrinter.printNode(root);
            System.out.println("------------------");
        }
    }

    public static <E> void outputList(List<E> list) {
        for (E elem : list) {
            System.out.print(elem + ", ");
        }
        System.out.println();
    }

    public boolean validNumber(String s) {
        if (s == null) return false;
        return s.matches("\\s*[+-]?((\\.[0-9]+)|([0-9]+(\\.[0-9]*)?))(e[+-]?[0-9]+)?\\s*");
    }

}


