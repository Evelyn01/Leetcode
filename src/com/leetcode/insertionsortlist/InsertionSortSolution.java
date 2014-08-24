package com.leetcode.insertionsortlist;

/**
 * Created by titan-developer on 8/16/14.
 * Sort a linked list using insertion sort.
 */

public class InsertionSortSolution {

    public static void main(String[] strings) {
        InsertionSortSolution insertionSortSolution = new InsertionSortSolution();
        insertionSortSolution.insertionSortList(generateList());
    }

    static ListNode generateList() {
        ListNode head = new ListNode(5);
        ListNode temp = new ListNode(3);
        head.next = temp;

        temp.next = new ListNode(4);
        temp = temp.next;

        temp.next = new ListNode(1);
        temp = temp.next;

        temp.next = new ListNode(7);
        temp = temp.next;

        temp.next = new ListNode(9);
        temp = temp.next;

        return head;
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null)
            return head;


        ListNode mockHead = new ListNode(0);
        mockHead.next = head;

        ListNode sortedTail = head;
        ListNode current = head.next;

        while (current != null) {

            ListNode cursor = mockHead;

            while (current.val > cursor.next.val && cursor.next != current) {
                cursor = cursor.next;
            }

            if (cursor.next == current) {
                sortedTail = current;
                current = current.next;
                continue;
            }

            ListNode temp = cursor.next;
            cursor.next = current;
            sortedTail.next = current.next;
            current.next = temp;

            current = sortedTail.next;
        }

        return mockHead.next;
    }

    /**
     * Definition for singly-linked list.
     */
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
