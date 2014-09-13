package com.leetcode.linkedlistcycle2;

import com.leetcode.common.ListNode;

/**
 * Created by titan-developer on 8/17/14.
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * Follow up:
 * Can you solve it without using extra space?
 */
public class LinkedListCycle2Solution {

    public static void main(String[] strings) {
        ListNode node = new ListNode(10);

        ListNode head = node;

        node.next = new ListNode(9);

        ListNode node9 = node.next;

        node = node.next;
        node.next = new ListNode(8);
        node = node.next;
        node.next = new ListNode(7);
        node = node.next;
        node.next = new ListNode(6);
        node = node.next;
        node.next = new ListNode(5);
        node = node.next;
        node.next = node9;

        LinkedListCycle2Solution linkedListCycle2Solution = new LinkedListCycle2Solution();

        ListNode cycleNode = linkedListCycle2Solution.detectCycle(head);
        System.out.println(cycleNode.val);
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode first = head;
        ListNode second = head;

        while (first != null && second != null) {
            first = first.next;
            second = second.next;
            if (second != null) {
                second = second.next;
            }
            if (first == second) {
                break;
            }
        }

        if (second == null) {
            return null;
        }

        first = head;
        while (first != second) {
            first = first.next;
            second = second.next;
        }

        return second;
    }
}
