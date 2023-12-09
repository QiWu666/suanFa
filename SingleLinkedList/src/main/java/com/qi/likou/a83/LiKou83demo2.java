package com.qi.likou.a83;

import com.qi.ListNode;

// TODO p79
public class LiKou83demo2 {
    public static ListNode deleteDuplicates(ListNode p) {
        if (p==null||p.next==null) {
            return p;
        }
        if (p.val==p.next.val) {
            return deleteDuplicates(p.next);
        }else {
            p.next = deleteDuplicates(p.next);
            return p;
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(2, new ListNode(5, null)))));
        System.out.println(LiKou83demo2.deleteDuplicates(node));
    }
}
