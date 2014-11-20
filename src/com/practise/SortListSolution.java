package com.practise;

import com.leetcode.common.ListNode;


/**
 * Created by bod on 11/20/2014.
 */
public class SortListSolution {

    public static void main(String[] strings) {
        ListNode head = ListNode.createList("2->3->1->6->5->7->4");

        SortListSolution solution = new SortListSolution();
        ListNode newHead = solution.sortList(head);
        ListNode.print(newHead);
    }

    public ListNode sortList(ListNode head) {

        int span = 1, length = -1, total = 0, count;

        ListNode current;

        ListNode leftList = null, rightList = null;

        while (length < 0 || span < length) {
            count = 0;
            current = head;
            head = null;
            while (current != null) {
                if (length < 0)
                    total++;

                count++;
                if (leftList == null && count == 1) {
                    leftList = current;
                } else if (rightList == null && count == 1) {
                    rightList = current;
                }

                ListNode next = current.next;
                if (count == span) {
                    count = 0;
                    current.next = null;

                    if (rightList != null || next == null) {
                        MergeResult result = merge(leftList, rightList);

                        if (head == null) {
                            head = result.head;
                        }

                        result.tail.next = next;

                        leftList = rightList = null;
                    }
                }

                current = next;
            }

            if (length < 0) {
                length = total;
            }

            span *= 2;
        }

        return head;
    }

    private MergeResult merge(ListNode leftList, ListNode rigthList) {
        ListNode dummyNode = new ListNode(-1);

        ListNode current = dummyNode;
        while (leftList != null || rigthList != null) {

            if (rigthList == null || (leftList != null && leftList.val < rigthList.val)) {
                current.next = leftList;
                leftList = leftList.next;
            } else{
                current.next = rigthList;
                rigthList = rigthList.next;
            }

            current = current.next;
        }

        MergeResult result = new MergeResult();
        result.head = dummyNode.next;
        result.tail = current;

        return result;
    }

    static class MergeResult {
        ListNode head;
        ListNode tail;
    }
}
