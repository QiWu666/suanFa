package com.qi.likou.a234;

import com.qi.ListNode;

/**
 * 步骤1,找中间点的同时反转前半个链表
 * 步骤2,反转后的前半个链表与中间点开始的后半个链表逐一比较
 */
// TODO P87
public class LeetCode234demo2 {
    public boolean isPalindrome(ListNode head) {
        ListNode p1 = head; // 慢节点
        ListNode p2 = head; // 快节点

        ListNode n1 = null; // 新指针
        ListNode o1 = head; // 旧指针
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            //反转链表
            o1.next = n1;
            n1 = o1;
            o1 = p1;
        }
        System.out.println(n1);
        System.out.println(p1);
        if (p2 != null) {
            p1 = p1.next;
        }
        //判断是否为回文列表
        while (n1 != null) {
            if (n1.val != p1.val) {
                return false;
            }
            n1 = n1.next;
            p1 = p1.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode nodes = ListNode.addNodes(1, 2, 2, 1, 2);
        ListNode nodes2 = ListNode.addNodes(1, 2, 3, 2, 1);
        System.out.println(new LeetCode234demo2().isPalindrome(nodes2));
    }
}
