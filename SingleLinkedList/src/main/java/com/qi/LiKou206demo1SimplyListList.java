package com.qi;

public class LiKou206demo1SimplyListList {

    public MyNode reverse(MyNode head) {
        MyNode myNode = null;
        while (head != null) {
            myNode = new MyNode(head.val, myNode);
            head = head.next;
        }
        return myNode;
    }

    public static void main(String[] args) {
        MyNode n1 = new MyNode(1, null);
        MyNode n2 = new MyNode(2, n1);
        MyNode n3 = new MyNode(3, n2);
        MyNode n4 = new MyNode(4, n3);
        MyNode n5 = new MyNode(5, n4);
        System.out.println(n5);
        LiKou206demo1SimplyListList re = new LiKou206demo1SimplyListList();
        System.out.println(re.reverse(n5));
    }
    private static class MyNode{
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
}

