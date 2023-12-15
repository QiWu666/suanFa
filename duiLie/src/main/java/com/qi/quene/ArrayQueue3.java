package com.qi.quene;

import java.util.Iterator;

/**
 * 仅用head，tail判断空满，head，tail需要换算成索引值
 */
// TODO P97
public class ArrayQueue3<E> implements Queue<E>, Iterable<E> {
    /*
    求模运算：
        如果除数是2的n次方
        那么被除数的后n位即为余数（模）
     */
    private final E[] array;
    private int head = 0;
    private int tail = 0;

    @SuppressWarnings("all")
    public ArrayQueue3(int capacity) {
        array = (E[]) new Object[capacity];
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
        array[tail % array.length] = value;
        tail++;
        return true;
    }

    @Override
    public E poll() {
        if (empty()) {
            return null;
        }
        E value = array[head % array.length];
        head++;
        return value;
    }

    @Override
    public E peek() {
        return array[head % array.length];
    }

    @Override
    public boolean empty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        return tail - head == array.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int p = head; // 换算成索引位置
            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public E next() {
                E value = array[p % array.length];
                p++;
                return value;
            }
        };
    }
}
