package com.qi.quene;

import java.util.Iterator;

public class ArrayQueue2<E> implements Queue<E>, Iterable<E> {
    private E[] array;
    private int head = 0; // 头指针
    private int tail; // 尾指针
    private int size; // 数组的有效长度

    /**
     * @param capacity 新建数组的容量
     */
    @SuppressWarnings("all")
    public ArrayQueue2(int capacity) {
        array = (E[]) new Object[capacity];
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
        array[tail] = value;
        tail = (tail + 1) % array.length;
        size++;
        return true;
    }

    @Override
    public E poll() {
        if (empty()) {
            return null;
        }
        E removed = array[head];
        head = (head + 1) % array.length;
        size--;
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
        return size==0;
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int p = head;
            int count = 0;

            @Override
            public boolean hasNext() {
                return count < size;
            }
            @Override
            public E next() {
                E e = array[p];
                p = (p + 1) % array.length;
                count++;
                return e;
            }
        };
    }
}
