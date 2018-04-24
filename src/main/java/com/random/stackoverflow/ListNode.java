package com.random.stackoverflow;

public class ListNode {

    public int data;
    public ListNode next;

    public ListNode() {

    }

    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }

    public ListNode(int data, ListNode next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
            "data=" + data +
            ", next=" + next +
            '}';
    }
}
