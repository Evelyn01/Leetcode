package com.leetcode.rotateList;

import com.leetcode.common.ListNode;

/**
 * Created by titan-developer on 10/31/14.
 */
public class RotateList {

    public static void main(String[] strings) {

        ListNode head1 = new ListNode(1);
//        head1.next = new ListNode(3);
//        head1.next.next = new ListNode(5);
//        head1.next.next.next = new ListNode(7);
//        head1.next.next.next.next = new ListNode(10);

        RotateList rotatee = new RotateList();

        ListNode node = rotatee.rotateRight(head1, 1);

        while (node != null) {
            System.out.print(node.val + ", ");
            node = node.next;
        }
    }

    /**
     * Since n may be a large number compared to the length of list. So we need to know the length of linked list.After that, move the list after the (l-n%l )th node to the front to finish the rotation.
     * <p/>
     * Ex: {1,2,3} k=2 Move the list after the 1st node to the front
     * <p/>
     * Ex: {1,2,3} k=5, In this case Move the list after (3-5%3=1)st node to the front.
     * <p/>
     * So the code has three parts.
     * <p/>
     * 1) Get the length
     * <p/>
     * 2) Move to the (l-n%l)th node
     * <p/>
     * 3)Do the rotation
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;

        int i;
        for (i = 0; fast.next != null; i++)//Get the total length
            fast = fast.next;

        for (int j = i - n % i; j > 0; j--) //Get the i-n%i th node
            slow = slow.next;

        fast.next = dummy.next; //Do the rotation
        dummy.next = slow.next;
        slow.next = null;

        return dummy.next;
    }
}
