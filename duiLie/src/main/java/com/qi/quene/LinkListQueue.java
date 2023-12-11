package com.qi.quene;

import java.util.Iterator;

// TODO BIG BUG
public class LinkListQueue<E> implements Queue<E>, Iterable<E> {
    private final Node<E> head = new Node<>(null, null);
    private Node<E> tail = head;

    {
        tail.next = head;
    }

    public LinkListQueue() {

    }

    private int size;
    private int capacity = 5;

    public LinkListQueue(int capacity) {
        this.capacity = capacity;
    }

    private static class Node<E> {
        E value;

        public Node() {

        }

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }

        Node<E> next;
    }


    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
        Node<E> added = new Node<>(value, null);
        tail.next = added;
        tail = added;
        size++;
        return true;
    }

    @Override
    public E poll() {
        if (empty()) {
            return null;
        }
        Node<E> first = head.next;
        if (tail == first) {
            tail = head;
            head.next = head;
        }
        size--;
        head.next = first.next;
        return first.value;
    }

    @Override
    public E peek() {
        if (empty()) {
            return null;
        }
        return head.next.value;
    }

    @Override
    public boolean empty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> p = head.next;

            @Override
            public boolean hasNext() {
                // 环链表，到哨兵节点就结束循环
                return p != head && p != null;
            }

            @Override
            public E next() {
                E value = p.value;
                p = p.next;
                return value;
            }
        };
    }
}
