package com.qi.likou.a19;


import com.qi.ListNode;

public class LiKou19demo1 {
    /**
     * @param n    要倒序删除的元素的下标
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode s = new ListNode(-1,null);
        s.next = head;
        recursion(s, n);
        return s.next;
    }
    // TODO p76 递归
    private int recursion(ListNode p, int n) {
        if (p == null) {
            return 0;
        }
        int nth = recursion(p.next, n); // 下一个节点的倒数位置
        if (nth == n) {
            // 假设 p=3  p.next=4  p.next.next=5
            p.next = p.next.next;
        }
        // 返回当前节点倒数位置
        return nth + 1;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        System.out.println(new LiKou19demo1().removeNthFromEnd(node, 1));
    }
}
