package leetcode;

import com.random.stackoverflow.ListNode;

public class RotateList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2,
            new ListNode(3, new ListNode(4))));
        System.out.println(rotateRight(head, 1));
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode temp = head;
        int length = 0;
        ListNode kthNodeFromEnd = null;
        ListNode kthNodeFromEndPrevious = null;
        ListNode tail = null;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        k = k % length;
        if (k == 0) {
            return head;
        }

        temp = head;
        length = 0;
        while (temp != null) {
            if (kthNodeFromEnd != null) {
                kthNodeFromEndPrevious = kthNodeFromEnd;
                kthNodeFromEnd = kthNodeFromEnd.next;
            }
            length++;
            if (length >= k && kthNodeFromEnd == null) {
                kthNodeFromEnd = head;
            }
            tail = temp;
            temp = temp.next;
        }
        System.out.println("The length of the list: " + length);
        k = k % length;
        //if kthNodeFromEnd is still null, the value of k was greater
        //than the length of the list.
        if (kthNodeFromEnd == null) {
            return null;
        }
        if (kthNodeFromEndPrevious != null) {
            kthNodeFromEndPrevious.next = null;
        }
        tail.next = head;
        head = kthNodeFromEnd;
        return head;
    }
}
