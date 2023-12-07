package com.qi.likou.a21;

import com.qi.ListNode;

public class LeetCode21demo2 {
    public ListNode mergeTwoLists(ListNode p1, ListNode p2) {
        if (p1 == null) {
            return p2;
        }
        if (p2 == null) {
            return p1;
        }
        if (p1.val < p2.val) {
            p1.next = mergeTwoLists(p1.next, p2);
            return p1;
        } else {
            p2.next = mergeTwoLists(p1, p2.next);
            return p2;
        }
    }
    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(2, new ListNode(5, null)))));
        ListNode node2 = new ListNode(3, new ListNode(4, new ListNode(6, new ListNode(7, new ListNode(8, null)))));
        System.out.println(LeetCode21demo1.mergeTwoLists(node, node2));
    }
}
