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
    public static ListNode addNodes(int... elements) {
        if (elements == null || elements.length == 0) {
            return null;
        }

        ListNode head = new ListNode(elements[0], null);
        ListNode current = head;

        for (int i = 1; i < elements.length; i++) {
            ListNode newNode = new ListNode(elements[i], null);
            current.next = newNode;
            current = newNode;
        }

        return head;
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
