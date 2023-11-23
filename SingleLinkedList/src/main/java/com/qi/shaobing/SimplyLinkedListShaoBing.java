package com.qi.shaobing;

import com.qi.SimplyLinkedList;

import java.util.Iterator;

public class SimplyLinkedListShaoBing implements Iterable<Integer> {

    private Node head = new Node(666, null);

    public void addFirst(int value) {
        insert(0,value);
    }

    public void loop() {
        Node p = head.next;
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
            Node p = head.next;

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

    private Node findLast() {
        Node p;
        for (p = head; p.next != null; p = p.next) {

        }
        return p;
    }

    public void addLast(int value) {
        Node last = findLast();
        last.next = new Node(value, null);
    }

    private Node findNode(int index) {
        int i = -1;
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
        Node preNode = get(index - 1);
        if (preNode == null) {
            illegalArgExcept();
        }
        preNode.next = new Node(value, preNode.next);
    }

    /**
     *
     */
    public void removeFirst() {
        remove(0);
    }

    public void remove(int index) {
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