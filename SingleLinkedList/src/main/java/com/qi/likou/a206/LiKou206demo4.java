package com.qi.likou.a206;

import com.qi.ListNode;

public class LiKou206demo4 {
    /**
     * @param old1 节点头(节点永远不变)
 *            old2 旧的节点头的下一个节点(要被插入头节点的节点)
     * @return
     */
    public static ListNode reverseList(ListNode old1) {
        // 新的节点头(head)
        ListNode new1 = old1;
        ListNode old2 = old1.next;
        while (old2 != null) {
            old1.next = old2.next; // 2
            old2.next = new1; // 3
            new1 = old2; // 4
            old2 = old1.next; // 5
        }
        //
        return new1;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        System.out.println(LiKou206demo4.reverseList(node));
    }
}
