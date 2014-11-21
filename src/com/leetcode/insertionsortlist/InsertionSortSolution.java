package com.leetcode.insertionsortlist;

import com.leetcode.common.ListNode;

/**
 * Created by titan-developer on 8/16/14.
 * Sort a linked list using insertion sort.
 */

public class InsertionSortSolution {

    public static void main(String[] strings) {
        InsertionSortSolution insertionSortSolution = new InsertionSortSolution();
        insertionSortSolution.insertionSortList(ListNode.createList("5->3->4->1->7->9"));
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
}
