package com.qi.quene;

import java.util.Iterator;

public class ArrayQueue1<E> implements Queue<E>, Iterable<E> {
    private final E[] array;
    private static int head = 0; // 头指针
    private int tail = 0; // 尾指针

    /**
     * @param capacity 新建数组的容量
     */
    @SuppressWarnings("all")
    public ArrayQueue1(int capacity) {
        array = (E[]) new Object[capacity + 1];
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
        array[tail] = value;
        tail = (tail + 1) % array.length;
        return true;
    }

    @Override
    public E poll() {
        if (empty()) {
            return null;
        }
        E removed = array[head];
        head = (head + 1) % array.length;
        return removed;
    }

    @Override
    public E peek() {
        if (empty()) {
            return null;
        }
        return array[head];
    }

    @Override
    public boolean empty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        return (tail + 1) % array.length == head;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int p = head;

            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public E next() {
                E e = array[p];
                p = (p + 1) % array.length;
                return e;
            }
        };
    }
}
