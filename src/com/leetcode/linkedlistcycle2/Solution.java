package com.leetcode.linkedlistcycle2;

/**
 * Created by titan-developer on 8/17/14.
 */
public class Solution {

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

        Solution solution = new Solution();

        ListNode cycleNode = solution.detectCycle(head);
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
            if(second != null) {
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
