package com.leetcode.swapnodespairs;

import com.leetcode.common.ListNode;

/**
 * Created by titan-developer on 10/29/14.
 * https://oj.leetcode.com/problems/swap-nodes-in-pairs/
 */
public class SwapNodesInPairs {

    public static void main(String[] strings) {
        ListNode head = new ListNode(1);
        ListNode h = head;

        head.next = new ListNode(2);
        head = head.next;

        head.next = new ListNode(3);
        head = head.next;

        head.next = new ListNode(4);
        head = head.next;

        head.next = new ListNode(5);

        SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();
        head = swapNodesInPairs.swapPairs(h);

        while (head != null) {
            System.out.print(head.val + ", ");
            head = head.next;
        }
    }

    public ListNode swapPairs(ListNode head) {

        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;

        ListNode start, a, b, end;
        start = fakeHead;
        while (start.next != null) {
            a = start.next;
            b = a.next;
            if (b == null) {
                break;
            } else {
                end = b.next;
                swap(start, a, b, end);
                start = a;
            }
        }

        return fakeHead.next;
    }

    private void swap(ListNode start, ListNode a, ListNode b, ListNode end) {
        start.next = b;
        b.next = a;
        a.next = end;
    }
}
