package com.qi;

public class LiKou206Test {
    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode newNode = null;
            while (head != null) {
                newNode = new ListNode(head.val, newNode);
                head = head.next;
            }
            return newNode;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


}
