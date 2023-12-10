package com.qi.likou.a876;

import com.qi.ListNode;

/**
 *  使用快慢指针实现
 *  p1 移动一次
 *  p2 移动两次
 */
public class LeetCode876 {
    /*
            p1     p2
        1 2 3 4 5 null
        p1
                    p2
        1 2 3 4 5 6 null
    */
    public ListNode middleNode(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
            p2 = p2.next;
        }
        return p1;
    }

    public static void main(String[] args) {
        ListNode nodes = ListNode.addNodes(1, 2, 3, 4, 5);
        ListNode nodes2 = ListNode.addNodes(1, 2, 3, 4, 5,6);
        System.out.println(new LeetCode876().middleNode(nodes));
        System.out.println(new LeetCode876().middleNode(nodes2));
    }
}
