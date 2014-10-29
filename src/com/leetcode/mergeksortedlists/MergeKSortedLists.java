package com.leetcode.mergeksortedlists;

import com.leetcode.common.ListNode;
import com.leetcode.mergeksortedlist.MergeKSortedList;

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

        MergeKSortedList merger = new MergeKSortedList();

        ListNode head = merger.mergeKLists(list);

        while (head != null) {
            System.out.print(head.val + ", ");
        }
    }

    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null) {
            return null;
        } else if (lists.size() < 2) {
            return lists.get(0);
        }

        ListNode head = null;

        int size  = lists.size();

        for (int i = size; i > )

        return head;
    }
}
