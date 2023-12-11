package com.qi.likou.a234;

import com.qi.ListNode;

/**
 * 判断回文链表
 * <br/>
 * 输入：head=[1,2,2,1]
 * 输出：true
 * <br/>
 * 解题思路：找出链表中间点，把中间点右边的链表反转，逐一比较反转后的链表与中间点左边的链表是否一致。
 */
public class LeetCode234demo1 {
    /*
    步骤1，找中间点
    步骤2：中间点后半个链表反转
    步骤3：反转后链表与原链表逐一比较
     */
    public boolean isPalindrome(ListNode head) {
        ListNode middle = middle(head);
        ListNode newList = reverse(middle);
        while (newList != null) {
            if (newList.val!= head.val) {
                return false;
            }
            newList = newList.next;
            head = head.next;
        }
        return true;
    }

    private ListNode reverse(ListNode o1) {
        ListNode n1 = null;
        while (o1 != null) {
            ListNode o2 = o1.next;
            o1.next = n1;
            n1 = o1;
            o1 = o2;
        }
        return n1;
    }
    //找中间点
    private ListNode middle(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }

    public static void main(String[] args) {
        ListNode nodes = ListNode.addNodes(1, 2, 2, 1,2);
        ListNode nodes2 = ListNode.addNodes(1, 2, 3, 2, 1);
        System.out.println(new LeetCode234demo1().isPalindrome(nodes));
        new LeetCode234demo1().isPalindrome(nodes2);
    }
}
