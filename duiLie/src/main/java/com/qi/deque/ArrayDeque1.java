package com.qi.deque;

import java.util.Iterator;

/**
 * 基于循环数组实现，特点
 * tail停下来的位置不存储，会浪费一个位置
 */
public class ArrayDeque1<E> implements Deque<E>, Iterable<E> {
    private final E[] array;
    private int head;
    private int tail;

    @SuppressWarnings("all")
    public ArrayDeque1(int capacity) {
        array = (E[]) new Object[capacity];
    }

    static int inc(int i, int length) {
        if (i + 1 >= length) {
            return 0;
        }
        return i + 1;
    }

    static int dec(int i, int length) {
        if (i - 1 < 0) {
            return length - 1;
        }
        return i - 1;
    }

    @Override
    public boolean offerFirst(E value) {
        if (isFull()) {
            return false;
        }
        head = dec(head, array.length);
        array[head] = value;
        return true;
    }

    @Override
    public boolean offerLast(E value) {
        if (isFull()) {
            return false;
        }
        array[tail] = value;
        tail = inc(tail, array.length);
        return true;
    }

    @Override
    public E pollFirst() {
        E e = array[head];
        array[head] = null; //help GC
        tail = inc(head, array.length);
        return e;
    }

    @Override
    public E pollLast() {
        tail = inc(tail, array.length);
        E e = array[tail];
        array[tail] = null;
        return e;
    }

    @Override
    public E peekFirst() {
        return null;
    }

    @Override
    public E peekLast() {
        if (isEmpty()) {
            return null;
        }
        return array[dec(tail, array.length)];
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    // TODO P115
    @Override
    public boolean isFull() {
        if (head > tail) {
            return head - tail == 1;
        } else if (head < tail) {
            return tail - head == array.length - 1;
        } else {
            return false;
        }
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
                p = inc(p, array.length);
                return e;
            }
        };
    }

}
