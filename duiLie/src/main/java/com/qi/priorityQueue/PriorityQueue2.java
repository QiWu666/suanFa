package com.qi.priorityQueue;

import com.qi.quene.Queue;

/**
 * 基于有序数组实现
 * <E> -队列中元素类型，必须实现Priority接口
 */
// TODO NO TESTED
public class PriorityQueue2<E extends Priority> implements Queue<E> {
    private final Priority[] array;
    private int size;

    public PriorityQueue2(int capacity) {
        array = new Priority[capacity];
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
        insert(value);
        size++;
        return true;
    }

    /**
     * 插入排序
     */
    private void insert(E value) {
        int i = size - 1;
        while (i >= 0 && array[i].priority() > value.priority()) {
            array[i + 1] = array[i];
            i--;
        }
        array[i + 1] = value;
    }

    /**
     * @return 删除优先级最高的元素
     */
    @Override
    public E poll() {
        if (empty()) {
            return null;
        }
        Priority priority = array[size - 1];
        size--;
        array[size] = null;
        return (E) priority;
    }

    /**
     * @return 返回优先级最高的元素
     */
    @Override
    public E peek() {
        if (empty()) {
            return null;
        }
        return (E) array[size-1];
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
