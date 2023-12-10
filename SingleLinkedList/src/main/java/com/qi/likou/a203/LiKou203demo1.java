package com.qi.likou.a203;

import com.qi.ListNode;

public class LiKou203demo1 {
    /**
     * @param head 链表头
     * @param val  要删除的值
     * @return 删除后的链表
     */
    public static ListNode removeElements(ListNode head, int val) {
        // 哨兵节点
        ListNode s = new ListNode(-1, head);
        ListNode p1 = s;
        // 要比较的节点值
        ListNode p2 = s.next;
        if (head == null) {
            return head;
        }
        while (p2 != null) {
            if (p2.val == val) {
                // 删除逻辑 , p2 向后平移
                p1.next = p2.next;
                //p2 = p2.next;
            }else {
                p1 = p1.next;
//                p2 = p2.next;
            }
            p2 = p1.next;
        }
        return s.next;
    }

    public static void main(String[] args) {
        //ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(3, null))))));
//        System.out.println(LiKou203demo1.removeElements(node, 2));
        ListNode node = new ListNode(7, new ListNode(7, new ListNode(7, new ListNode(7, null))));
        System.out.println(LiKou203demo1.removeElements(node,7));
    }
}
