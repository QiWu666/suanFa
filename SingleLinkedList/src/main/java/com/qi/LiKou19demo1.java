package com.qi;

public class LiKou19demo1 {
    /**
     * @param head
     * @param n    要倒叙删除的元素的下标
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        recursion(head, n);
        return head;
    }
    // TODO p76 递归
    //
    private int recursion(ListNode p, int n) {
        if (p == null) {
            return 0;
        }
        int nth = recursion(p.next, n); // 下一个节点的倒数位置
        if (nth == n) {
            // 假设 p=3  p.next=4  p.next.next=5
            p.next = p.next.next;
        }
        return nth + 1;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        System.out.println(new LiKou19demo1().removeNthFromEnd(node, 2));
    }
}
