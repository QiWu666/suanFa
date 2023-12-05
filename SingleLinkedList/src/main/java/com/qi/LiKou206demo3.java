package com.qi;

public class LiKou206demo3 {
    //TODO p71算法,力扣206
    public ListNode reverseList(ListNode p) {
        if (p == null || p.next == null) {
            return p;//返回最后节点
        }
        ListNode last = reverseList(p.next);
        p.next.next = p;
        p.next = null;
        return last;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        LiKou206demo3 demo3 = new LiKou206demo3();
        System.out.println(demo3.reverseList(node));
    }
}
