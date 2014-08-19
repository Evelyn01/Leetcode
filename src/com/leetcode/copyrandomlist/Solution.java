package com.leetcode.copyrandomlist;

import com.leetcode.sortlinkedlist.ListNode;

import java.util.HashMap;

/**
 * Created by titan-developer on 8/18/14.
 */
public class Solution {

    public static void main(String[] string) {

        RandomListNode head = new RandomListNode(0);
        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);
        RandomListNode node4 = new RandomListNode(4);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        head.random = node3;
        node1.random = node4;
        node2.random = head;
        node4.random = node2;

        Solution solution = new Solution();

        RandomListNode newHead = solution.copyRandomList(head);

        System.out.println(newHead.label);
    }


    HashMap<RandomListNode, RandomListNode> hashMap;

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return head;
        }

        hashMap = new HashMap<RandomListNode, RandomListNode>();

        RandomListNode newHead = new RandomListNode(head.label);

        RandomListNode dest = newHead;

        hashMap.put(head, newHead);

        RandomListNode ori = head.next;

        while (ori != null) {
            RandomListNode temp = new RandomListNode(ori.label);

            hashMap.put(ori, temp);

            dest.next = temp;

            dest = temp;

            ori = ori.next;
        }

        ori = head;
        dest = newHead;

        while (ori != null && dest != null) {
            if (ori.random != null) {
                RandomListNode random = hashMap.get(ori.random);
                if (random != null) {
                    dest.random = random;
                }
            }

            ori = ori.next;
            dest = dest.next;
        }

        return newHead;
    }

    public RandomListNode copyRandomListExtra1Space(RandomListNode head) {
        if (head == null) {
            return head;
        }

        RandomListNode ori = head;

        while (ori != null) {
            RandomListNode copy = new RandomListNode(ori.label);

            RandomListNode next = ori.next;

            ori.next = copy;

            copy.next = next;

            ori = next;
        }

        ori = head;

        while (ori != null) {
            if (ori.random == null) {
                ori.next.random = null;
            } else {
                ori.next.random = ori.random.next;
            }

            ori = ori.next.next;
        }

        ori = head;

        RandomListNode newHead = ori.next;

        RandomListNode current = newHead;

        while (true) {
            ori.next = current.next;
            ori = ori.next;

            if (ori == null) {
                break;
            }

            current.next = ori.next;
            current = current.next;
        }

        return newHead;
    }

    /**
     * Definition for singly-linked list with a random pointer.
     */
    static class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }
}
