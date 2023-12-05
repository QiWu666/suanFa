package com.qi;

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
            return "Node{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
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
}

