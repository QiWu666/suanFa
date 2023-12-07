package com.qi.likou.a82;

import com.qi.ListNode;

/**
 * 有序列表删值，注意：不保留重复元素
 */
// TODO p80
public class LeetCode82demo2 {
    public static ListNode deleteDuplicates(ListNode p) {
        if (p == null || p.next == null) {
            return p;
        }
        ListNode s = new ListNode(-1, p);
        ListNode p1 = s;
        ListNode p2, p3;
        while ((p2 = p1.next) != null && (p3 = p2.next) != null) {
            if (p2.val == p3.val) {
                while ((p3 = p3.next) != null && p3.val == p2.val) {
                }
                //p3找到了不重复的值
                p1.next = p3;
            }else {
                p1 = p1.next;
            }
        }
        return s.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(2, new ListNode(5, null)))));
        System.out.println(LeetCode82demo2.deleteDuplicates(node));
    }
}
