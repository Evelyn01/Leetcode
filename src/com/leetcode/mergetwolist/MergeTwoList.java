package com.leetcode.mergetwolist;

import com.leetcode.common.ListNode;

/**
 * Created by titan-developer on 10/31/14.
 */
public class MergeTwoList {

    public static void main(String[] strings) {
        ListNode head0 = new ListNode(2);
        head0.next = new ListNode(4);
        head0.next.next = new ListNode(6);

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(5);
        head1.next.next.next = new ListNode(7);
        head1.next.next.next.next = new ListNode(10);

        MergeTwoList merger = new MergeTwoList();

        ListNode mergedHead = merger.mergeTwoLists(head0, head1);

        while (mergedHead != null) {
            System.out.print(mergedHead.val + ", ");
            mergedHead = mergedHead.next;
        }
    }

    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode head, current;

        if (a == null) {
            return b;
        } else if (b == null) {
            return a;
        }

        if (a.val < b.val) {
            head = a;
            a = a.next;
        } else {
            head = b;
            b = b.next;
        }

        current = head;
        while (a != null && b != null) {
            if (a.val < b.val) {
                current.next = a;
                a = a.next;
            } else {
                current.next = b;
                b = b.next;
            }
            current = current.next;
        }

        if (a != null) {
            current.next = a;
        } else {
            current.next = b;
        }

        return head;
    }
}
