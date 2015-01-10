package com.practise1;

import com.leetcode.util.ListNode;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by titan-developer on 12/29/14.
 */
public class TestPractise {

    public static void main(String[] strings) {

        char[][] a = {
                {'0', '0', '0'},
                {'0', '0', '0'},
                {'0', '0', '0'},

        };

        char[][] b = {
                {'a'},
        };

        TestPractise testPractise = new TestPractise();
        System.out.println(testPractise.partition(ListNode.createList("2->1"), 2));
        System.out.println();
    }

    public static <E> void outputList(List<E> list) {
        for (E elem : list) {
            System.out.print(elem + ", ");
        }
        System.out.println();
    }

    public ListNode partition(ListNode head, int x) {
        //At tahoe
        if (head == null) return head;
        ListNode dummyLeft = new ListNode(-1);
        ListNode dummyRight = new ListNode(-1);
        ListNode left = dummyLeft, right = dummyRight;
        while (head != null) {
            if (head.val < x) {
                left.next = head;
                left = head;
            } else {
                right.next = head;
                right = head;
            }
            head = head.next;
        }
        left.next = dummyRight.next;
        dummyRight.next = null;
        return dummyLeft.next;
    }
}


