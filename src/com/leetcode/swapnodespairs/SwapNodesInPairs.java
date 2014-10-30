package com.leetcode.swapnodespairs;

import com.leetcode.common.ListNode;

/**
 * Created by titan-developer on 10/29/14.
 * https://oj.leetcode.com/problems/swap-nodes-in-pairs/
 */
public class SwapNodesInPairs {

    public static void main(String[] strings) {
        ListNode head = new ListNode(1);

        head.next = new ListNode(2);
        head = head.next;

        head.next = new ListNode(3);
        head = head.next;

        head.next = new ListNode(4);
        head = head.next;

        head.next = new ListNode(5);

        SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();
        head = swapNodesInPairs.swapPairs(head);

        while (head != null) {
            System.out.print(head.val + ", ");
            head = head.next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        return null;
    }
}
