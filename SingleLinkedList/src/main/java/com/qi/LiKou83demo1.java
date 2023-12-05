package com.qi;

public class LiKou83demo1 {
    /**
     * 删除链表中重复节点
     *
     * @param head 头节点
     * @return 删除后的头节点
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p1 = head;
        ListNode p2;
        while ((p2 = p1.next) != null) {
            if (p1.val == p2.val) {
                p1.next = p2.next;
            } else {
                //向后平移
                p1 = p1.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(2, new ListNode(5, null)))));
        System.out.println(LiKou83demo1.deleteDuplicates(node));
    }
}
