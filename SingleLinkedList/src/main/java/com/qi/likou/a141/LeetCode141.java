package com.qi.likou.a141;

import com.qi.ListNode;

/**
 * 检测链表是否有环
 */
/*
    龟一次走一步，兔子一次走两步
    当兔子能走到终点时，不存在环
    当兔子能追上龟时，可以判断存在环
 */
public class LeetCode141 {
    public boolean hasCycle(ListNode head) {
        ListNode h = head; // 兔
        ListNode t = head; // 龟
        while (h != null && h.next != null) {
            h = h.next.next;
            t = t.next;
            if (h == t) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode node12 = new ListNode(1, null);
        ListNode node11 = new ListNode(1, node12);
        ListNode node10 = new ListNode(1, node11);
        ListNode node9 = new ListNode(1, node10);
        ListNode node8 = new ListNode(1, node9);
        ListNode node7 = new ListNode(1, node8);
        ListNode node6 = new ListNode(1, node7);
        ListNode node5 = new ListNode(1, node6);
        ListNode node4 = new ListNode(1, node5);
        ListNode node3 = new ListNode(1, node4);
        ListNode node2 = new ListNode(1, node3);
        ListNode node1 = new ListNode(1, node2);
//        node12.next = node7;
        System.out.println(new LeetCode141().hasCycle(node1));
    }
}
