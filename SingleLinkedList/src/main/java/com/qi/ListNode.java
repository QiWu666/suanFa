package com.qi;

/**
 * 单链表用到的节点类
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "LinkNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
