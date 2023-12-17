package com.qi.zhan.impl;

import com.qi.zhan.Stack;

import java.util.Iterator;

public class LinkedListStack<E> implements Stack<E>, Iterable<E> {
    private final int capacity;
    public int size;
    // 哨兵节点
    private final Node<E> head = new Node<>(null, null);
    @Override
    public boolean push(E value) {
        if (isFull()) {
            return false;
        }
        // head
        // 1 -> head
        // 2 -> 1 -> head
        Node<E> added = new Node<>(value, head.next);
        head.next = added;
        size++;
        return true;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        Node<E> first = head.next;
        head.next = first.next;
        size--;
        return first.value;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return head.next.value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return capacity == size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> p = head.next;
            @Override
            public boolean hasNext() {
                return p!=null;
            }

            @Override
            public E next() {
                E val = p.value;
                p = p.next;
                return val;
            }
        };
    }

    public LinkedListStack(int capacity) {
        this.capacity = capacity;
    }

    static class Node<E>{
        E value;
        Node<E> next;
        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }
}
