package com.qi.likou.a23;

import com.qi.ListNode;
import com.qi.likou.a21.LeetCode21demo1;

public class LeetCode23demo1 {
    public static ListNode mergeTwoLists(ListNode n1, ListNode n2) {
        ListNode newLNode = new ListNode(-1, null);
        ListNode p = newLNode;
        while (n1 != null && n2 != null) {
            if (n1.val > n2.val) {
                p.next = n2;
                n2 = n2.next;
            } else {
                p.next = n1;
                n1 = n1.next;
            }
            p = p.next;

        }
        //n1,n2有一个为空
        if (n1 != null) {
            p.next = n1;
        }
        if (n2 != null) {
            p.next = n2;
        }
        return newLNode.next;
    }

    public ListNode mergeKLists(ListNode[] listNodes) {
        if (listNodes.length==0) {
            return null;
        }
        return split(listNodes, 0, listNodes.length);
    }

    /**
     * @param lists 链表
     * @param i     左边界
     * @param j     右边界
     * @return 合并后的列表
     */
    private ListNode split(ListNode[] lists, int i, int j) {
        if (i == j) {
            return lists[i];
        }
        int m = (i + j) >>> 1;
        ListNode left = split(lists, i, m);
        ListNode right = split(lists, m + 1, j);
        return mergeTwoLists(left, right);
    }
    //TODO  WILL TO FIXED BUG
    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(3, null));
        ListNode node2 = new ListNode(4, new ListNode(2, null));
        ListNode node3 = new ListNode(7, new ListNode(6, null));
        ListNode node4 = new ListNode(9, new ListNode(8, null));
        ListNode[] listNodes = {node, node2, node3, node4};
        LeetCode23demo1 leetCode23demo1 = new LeetCode23demo1();
        leetCode23demo1.mergeKLists(listNodes);
    }
}
