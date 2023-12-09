package com.qi.likou.a21;

import com.qi.ListNode;
import com.qi.likou.a82.LeetCode82demo2;

/**
 * 合并两个有序链表
 */
public class LeetCode21demo1 {
    public static ListNode mergeTwoLists(ListNode n1, ListNode n2) {
        ListNode newLNode = new ListNode(-1, null);
        ListNode p = newLNode;
        while (n1 != null && n2 != null) {
            if (n1.val > n2.val) {
                p.next = n2;
                n2 = n2.next;
            } else {
                p.next = n1;
                n1 = n1.next;
            }
            p = p.next;

        }
        //n1,n2有一个为空
        if (n1 != null) {
            p.next = n1;
        }
        if (n2 != null) {
            p.next = n2;
        }
        return newLNode.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(2, new ListNode(5, null)))));
        ListNode node2 = new ListNode(3, new ListNode(4, new ListNode(6, new ListNode(7, new ListNode(8, null)))));
        System.out.println(LeetCode21demo1.mergeTwoLists(node, node2));
    }
}
