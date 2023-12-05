package com.qi;

public class LiKou206demo5 {
    public static ListNode reverseList(ListNode old1) {
        ListNode new1 = null;
        while (old1 != null) {
            ListNode old2 = old1.next;
            old1.next = new1;
            new1 = old1;
            old1 = old2;
        }
        return new1;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        System.out.println(LiKou206demo5.reverseList(node));
    }
}
