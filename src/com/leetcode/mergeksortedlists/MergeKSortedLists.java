package com.leetcode.mergeksortedlists;

import com.leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by titan-developer on 10/29/14.
 */
public class MergeKSortedLists {

    public static void main(String[] strings) {
        ListNode head0 = new ListNode(2);
        head0.next = new ListNode(4);
        head0.next.next = new ListNode(6);

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(5);

        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(6);
        head2.next.next = new ListNode(7);

        List<ListNode> list = new ArrayList<ListNode>();
        list.add(head0);
        list.add(head1);
        list.add(head2);

        MergeKSortedLists merger = new MergeKSortedLists();

        ListNode head = merger.mergeKLists(list);

        while (head != null) {
            System.out.print(head.val + ", ");
            head = head.next;
        }
    }

    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        } else if (lists.size() < 2) {
            return lists.get(0);
        }

        while (lists.size() > 1) {
            int size = lists.size();

            for (int i = size - 1; i >= 0; i--) {
                if (i >= 1) {
                    ListNode a = lists.get(i);
                    ListNode b = lists.get(i -1);

                    ListNode c = mergeList(a, b);
                    lists.remove(i);
                    lists.remove(i - 1);
                    lists.add(c);
                    i --;
                }
            }
        }

        return lists.get(0);
    }

    private ListNode mergeList(ListNode a, ListNode b) {
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
