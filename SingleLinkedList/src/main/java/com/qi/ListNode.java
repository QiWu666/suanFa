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
        StringBuilder result = new StringBuilder("[");
        ListNode current = this;

        while (current != null) {
            result.append(current.val);
            if (current.next != null) {
                result.append(",");
            }
            current = current.next;
        }

        result.append("]");
        return result.toString();
    }
}
