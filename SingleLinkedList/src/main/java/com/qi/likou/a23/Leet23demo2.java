package com.qi.likou.a23;

import com.qi.ListNode;
//
public class Leet23demo2 {
    public ListNode mergeKLists(ListNode[] lists) {
        MinHeap heap = new MinHeap(lists.length);
        // 1. 将链表的头节点加入小顶堆
        for (ListNode listNode : lists) {
            if (listNode != null) {
                heap.offer(listNode);
            }
        }
        // 2. 不断从堆顶移除最小元素，加入新链表
        ListNode s = new ListNode(-1, null);
        ListNode t = s;
        while (!heap.isEmpty()) {
            // 从队列头中删除元素
            ListNode min = heap.poll();
            t.next = min;
            t = min;
            if (min.next!=null) {
                heap.offer(min.next);
            }
        }
        return s.next;
    }

    public static void main(String[] args) {
        ListNode[] listNodes = {new ListNode(1, new ListNode(4, new ListNode(5, null))),
                new ListNode(1, new ListNode(3, new ListNode(4, null))),
                new ListNode(2, new ListNode(6, null)),};
        System.out.println(new Leet23demo2().mergeKLists(listNodes));
    }
}
