package com.leetcode.reversenodeskgroup;

import com.leetcode.common.ListNode;

/**
 * Created by titan-developer on 10/29/14.
 * https://oj.leetcode.com/problems/reverse-nodes-in-k-group/
 */
public class ReverseNodesInKGroup {

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
        head = head.next;

        head.next = new ListNode(6);

        ReverseNodesInKGroup reverser = new ReverseNodesInKGroup();
        head = reverser.reverseKGroup(h, 2);

        while (head != null) {
            System.out.print(head.val + ", ");
            head = head.next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }

        ListNode start = null, end, lastTail = null, newHead = null;
        int count = 0;


        while (head != null) {
            if (count == 0) {
                start = head;
            }
            count ++;

            if (count == k) {
                end = head;
                head = head.next;
                end.next = null;
                reverse(start);
                if (lastTail != null) {
                    lastTail.next = end;
                    lastTail = start;
                }
                count = 0;
                start.next = head;


                if (newHead == null) {
                    newHead = end;
                    lastTail = start;
                }

            } else {
                head = head.next;
            }
        }

        if (newHead == null) {
            newHead = start;
        }

        return newHead;
    }

    private void reverse(ListNode start) {
        ListNode last = null, next;

        while (start != null) {
            next = start.next;
            start.next = last;
            last = start;
            start = next;
        }
    }
}
