package com.qi.priorityQueue;

import com.qi.quene.Queue;

/**
 * 无序列表实现优先级队列
 */
public class PriorityQueue1<E extends Priority> implements Queue<E> {
    Priority[] array;
    int size;

    public PriorityQueue1(int capacity) {
        array = new Priority[capacity];
    }

    @Override
    public boolean offer(E value) {
        array[size++] = value;
        return true;
    }

    @Override
    public E poll() {
        if (empty()) {
            return null;
        }
        int max = selectMax();
        E removed = (E) array[max];
        remove(max);
        return removed;
    }

    private void remove(int index) {
        if (index < size - 1) {
            System.arraycopy(array, index + 1, array, index, size - 1 - index);
        }
        size--;
    }


    @Override
    public E peek() {
        if (empty()) {
            return null;
        }
        int max = selectMax();
        return (E) array[max];
    }

    //    返回优先级最高的索引值
    private int selectMax() {
        int max = 0;// 最大值的索引位置
        for (int i = 1; i < array.length; i++) {
            if (array[i].priority() > array[max].priority()) {
                max = i;
            }
        }
        return max;
    }

    @Override
    public boolean empty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }
}
