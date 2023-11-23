package com.qi;

import java.util.Iterator;

public class DoubleLinkedList implements Iterable<Integer>{
    @Override
    public String toString() {
        return "DoubleLinkedList{" +
                "head=" + head +
                ", tail=" + tail +
                '}';
    }

    Node head, tail;

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            Node headNext = head.next;
            @Override
            public boolean hasNext() {
                return headNext != tail ;
            }

            @Override
            public Integer next() {
                int value = headNext.value;
                headNext =  headNext.next;
                return value;
            }
        };
    }

    private static class Node {
        private Node prev;

        private int value;
        private Node next;


        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }

        public Node() {
        }

    }

    /**
     * 初始化两个哨兵
     */
    public DoubleLinkedList() {
        head = new Node(null, 0, null);
        tail = new Node(null, 99999, null);
        head.next = tail;
        tail.prev = head;
    }

    public Node findNode(int index) {
        int i = -1;
        for (Node p = head; p != tail; p = p.next, i++) {
            if (i == index) {
                return p;
            }
        }
        return null;
    }

    public void insert(int index, int value) {
        Node prev = findNode(index - 1);
        if (prev == null) {
            throw getIllegalArgumentException(index);
        }
        Node next = prev.next;
        Node inserted = new Node(prev, value, next);
        prev.next = inserted;
        next.prev = inserted;
    }

    public void foreach() {
        for (head = head.next; head.next != tail; head = head.next) {
            System.out.println(head.value);
        }
    }

    public void remove(int index) {
        Node prev = findNode(index - 1);
        if (prev == null) {
            throw getIllegalArgumentException(index);
        }
        Node removed = prev.next;
        if (removed == tail) {
            throw getIllegalArgumentException(index);
        }
        Node next = removed.next;
        prev.next = next;
        next.prev = prev;
    }

    public void removeFirst() {
        remove(0);
    }

    public void addLast(int value) {
        Node prev = tail.prev;
        Node inserted = new Node(prev, value, tail);
        prev.next = inserted;
        tail.prev = inserted;
    }

    public void removeLast() {
        Node removed = tail.prev;
        if (removed==head) {
            throw getIllegalArgumentException(0);
        }
        Node prev = removed.prev;
        prev.next = tail;
        tail.prev = prev;
    }

    private static IllegalArgumentException getIllegalArgumentException(int index) {
        return new IllegalArgumentException(String.valueOf(index));
    }
}
