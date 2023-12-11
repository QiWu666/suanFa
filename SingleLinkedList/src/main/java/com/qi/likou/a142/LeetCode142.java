package com.qi.likou.a142;

import com.qi.ListNode;

/**
 * 检测环的入口
 */
/*
    从它们第一次相遇开始，龟回到起点，兔于保持原位不变
    龟和兔子一次走一步
    当再次相遇时，地点就是环的入口
 */
public class LeetCode142 {
    public ListNode hasCycle(ListNode head) {
        ListNode h = head; // 兔
        ListNode t = head; // 龟
        while (h != null && h.next != null) {
            h = h.next.next;
            t = t.next;
            if (h == t) {
//                进入第二阶段
                t = head;
                while (true) {
                    if (t == h) {
                        return t;
                    }
                    t = t.next;
                    h = h.next;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode node12 = new ListNode(12, null);
        ListNode node11 = new ListNode(11, node12);
        ListNode node10 = new ListNode(10, node11);
        ListNode node9 = new ListNode(9, node10);
        ListNode node8 = new ListNode(8, node9);
        ListNode node7 = new ListNode(7, node8);
        ListNode node6 = new ListNode(6, node7);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        node12.next = node1;
        System.out.println(new LeetCode142().hasCycle(node1).val);
    }
}
