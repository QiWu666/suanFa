package com.qi;

import java.util.Iterator;
import java.util.function.Consumer;

public class SimplyLinkedList implements Iterable<Integer> {
    private static class Node {
        int value;
        Node next;

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node head = null;

    public void addFirst(int value) {
        //插入第一个元素
        //Node node1 = new Node(value, null);
        //插入第二个元素
        head = new Node(value, head);
    }

    public void loop() {
        Node p = head;
        while (p != null) {
            System.out.println(p.value);
            p = p.next;
        }
    }

    public void foreach() {

    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = head;

            @Override
            public boolean hasNext() {
                return p != null;
            }

            @Override
            public Integer next() {
                int tmp = p.value;
                p = p.next;
                return tmp;
            }
        };
    }

    //Consumer<Integer> beforeConsumer, Consumer<Integer> afterConsumer
    public void loopRecursion(Consumer beforeConsumer,Consumer afterConsumer) {
        recursion(head,beforeConsumer,afterConsumer);
    }

    private void recursion(Node curr, Consumer beforeConsumer, Consumer afterConsumer) {
        if (curr == null) return;
        System.out.println(curr.value);
        recursion(curr.next, beforeConsumer, afterConsumer);
        System.out.println(curr.value);
    }


    private Node findLast() {
        if (head == null) {
            return null;
        }
        Node p;
        for (p = head; p.next != null; p = p.next) {

        }
        return p;
    }

    public void addLast(int value) {
        Node last = findLast();
        if (last == null) {
            addFirst(value);
            return;
        }
        last.next = new Node(value, null);
    }

    private Node findNode(int index) {
        int i = 0;
        for (Node p = head; p != null; p = p.next, i++) {
            if (index == i) {
                return p;
            }
        }
        return null;
    }

    /**
     * @param index 找指定索引的节点
     * @return
     */
    public Node get(int index) {
        Node node = findNode(index);
        if (node == null) {
            illegalArgExcept();
        }
//        Node last = findLast();
        return node;
    }

    private static void illegalArgExcept() {
        throw new IllegalArgumentException("参数不合法");
    }

    /**
     * 指定索引添加节点
     *
     * @param index 索引
     * @param value 值
     */
    public void insert(int index, int value) {
        if (index == 0) {
            addFirst(value);
            return;
        }
        Node preNode = findNode(index - 1);
        if (preNode == null) {
            illegalArgExcept();
        }
        preNode.next = new Node(value, preNode.next);
    }

    /**
     *
     */
    public void removeFirst() {
        if (head == null) {
            illegalArgExcept();
        }
        head = head.next;
    }

    public void remove(int index) {
        //
        if (index == 0) {
            removeFirst();
            return;
        }
        Node prev = findNode(index - 1);
        if (prev == null) {
            illegalArgExcept();
        }
        Node removed = prev.next;
        if (removed == null) {
            illegalArgExcept();
        }
        prev.next = removed.next;
    }


}

