package com.qi.heap;

import java.util.Arrays;

/**
 * 堆
 */
// TODO 背!!! 建堆、上浮、下潜
public class Heap {
    public int[] array;
    int size;
    boolean max;

    public Heap(int capacity, boolean max) {
        this.array = new int[capacity];
        this.max = max;
    }

    public Heap(int[] array) {
        this.array = array;
        this.size = array.length;
        heapify();
    }

    public Heap(int[] array, boolean max) {
        this.array = array;
        this.size = array.length;
        this.max = max;
        heapify();
    }

    // 建堆
    private void heapify() {
        //如何找到最后这个非叶子节点 size / 2 - 1
        for (int i = size / 2 - 1; i >= 0; i--) {
            down(i);
        }
    }

    public int peek() {
        return array[0];
    }

    /**
     * 删除堆顶元素
     *
     * @return 返回被删除的堆顶元素
     */
    public int poll() {
        int top = array[0];
        swap(0, size - 1);
        size--;
        down(0);
        return top;
    }

    /**
     * 替换堆顶元素
     */
    public void replace(int replaced) {
        array[0] = replaced;
        down(0);
    }


    /**
     * 堆的尾部添加元素
     *
     * @return ：是否添加成功
     */
    public boolean offer(int offer) {
        if (size == array.length) {
            grow();
        }
        up(offer);
        size++;
        return true;
    }

    private void grow() {
        int capacity = size + (size >> 1);
        int[] newArray = new int[capacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    /**
     * 将offered元素上浮：直至offered小于父元素或到堆顶
     */
    private void up(int offered) {
        int child = size;
        while (child > 0) {
            int parent = (child - 1) / 2;
            boolean cmp = max ? offered > array[parent] : offered < array[parent];
            if (cmp) {
                array[child] = array[parent];
            } else {
                break;
            }
            child = parent;
        }
        array[child] = offered;
    }


    /**
     * 删除指定索引处元素
     *
     * @param index 索引
     * @return 被删除的值
     */
    public int poll(int index) {
        int deleted = array[index];
        swap(index, size - 1);
        size--;
        down(index);
        return deleted;
    }

    public int getSize() {
        return size;
    }

    /**
     * 将 parent 索引处的元素下潜
     */
    private void down(int parent) {
        int left = parent * 2 + 1;
        int right = left + 1;
        int maxOrMin = parent;
        if (left < size && (max ? array[left] > array[maxOrMin] : array[left] < array[maxOrMin])) {
            maxOrMin = left;
        }
        if (right < size && (max ? array[right] > array[maxOrMin] : array[right] < array[maxOrMin])) {
            maxOrMin = right;
        }
        if (maxOrMin != parent) {
            swap(maxOrMin, parent);
            down(maxOrMin); //找到了更大的孩子
        }
    }

    private void swap(int max, int parent) {
        int t = array[parent];
        array[parent] = array[max];
        array[max] = t;
    }

    public boolean isFull() {
        return size == array.length;
    }

    @Override
    public String toString() {
        return "Heap{" +
                "array=" + Arrays.toString(array) +
                ", size=" + size +
                ", max=" + max +
                '}';
    }
}
