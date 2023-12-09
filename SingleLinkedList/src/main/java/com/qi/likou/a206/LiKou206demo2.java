package com.qi.likou.a206;

import com.qi.ListNode;

public class LiKou206demo2 {

    static class List {
        MyNode head;

        public List() {
            this.head = head;
        }

        public List(MyNode head) {
            this.head = head;
        }

        public void addFirst(MyNode first) {
            first.next = head;
            head = first;
        }

        public MyNode removeFirst() {
            MyNode removed = head;
            if (removed != null) {
                head = removed.next;
            }
            return removed;
        }
    }

    static class MyNode {
        private int val;
        private MyNode next;

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder("[");
            MyNode current = this;

            while (current != null) {
                result.append(current.val);
                if (current.next != null) {
                    result.append(",");
                }
                current = current.next;
            }

            result.append("]");
            return result.toString();
        }

        public MyNode() {
        }

        public MyNode(int val, MyNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public LiKou206demo2() {
    }

    /**
     * 自己新建的链表
     * @param head
     * @return
     */
    public MyNode reverseList2(MyNode head) {
        List list = new List(head);
        List newList = new List(null);
        while (true) {
            MyNode removed = list.removeFirst();
            if (removed == null) {
                break;
            }
            newList.addFirst(removed);
        }
        return newList.head;
    }

    public static void main(String[] args) {
        LiKou206demo2.MyNode n1 = new LiKou206demo2.MyNode(1, null);
        LiKou206demo2.MyNode n2 = new LiKou206demo2.MyNode(2, n1);
        LiKou206demo2.MyNode n3 = new LiKou206demo2.MyNode(3, n2);
        LiKou206demo2.MyNode n4 = new LiKou206demo2.MyNode(4, n3);
        LiKou206demo2.MyNode n5 = new LiKou206demo2.MyNode(5, n4);
        //System.out.println(n5);
        LiKou206demo2 re = new LiKou206demo2();
        System.out.println(re.reverseList2(n5));
    }
}

