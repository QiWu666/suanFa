package com.qi.heap;

import java.util.Arrays;

/**
 * 大顶堆
 */
// TODO 背!!! 建堆、上浮、下潜
public class MaxHeap {
    int[] array;
    int size;

    public MaxHeap(int capacity) {
        array = new int[capacity];
    }

    public MaxHeap(int[] array) {
        this.array = array;
        this.size = array.length;
        heapify();
    }

    // 建堆
    private void heapify() {
        //如何找到最后这个非叶子节点 size / 2 -1
        for (int i = size / 2 - 1; i >= 0 ; i--) {
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
    public int pull() {
        int removed = array[0];
        swap(0, size - 1);
        size--;
        down(0);
        return removed;
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
     * @return ：是否添加成功
     */
    public boolean offer(int offer) {
        if (size == array.length) {
            return false;
        }
        up(offer);
        size++;
        return true;
    }

    /**
     * 将offered元素上浮：直至offered小于父元素或到堆顶
     */
    private void up(int offered) {
        int child = size;
        while (child > 0) {
            int parent = (child - 1) / 2;
            if (offered > array[parent]) {
                array[parent] = array[child];
            }else {
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
        int removed = array[index];
        swap(index, size - 1);
        size--;
        down(index);
        return removed;
    }

    /**
     * 将 parent 索引处的元素下潜：与两个孩子较大者交换，直至没孩子或孩子没它大
     */
    private void down(int parent) {
        int left = parent * 2 + 1;
        int right = left + 1;
        int max = parent;
        if (left < size && array[left] > array[max]) {
            max = left;
        }
        if (right < size && array[right] > array[max]) {
            max = right;
        }
        if (max != parent) {
            swap(max,parent);
            down(max); //找到了更大的孩子
        }
    }

    private void swap(int max, int parent) {
        int t = array[parent];
        array[parent] = array[max];
        array[max] = t;
    }

    public static void main(String[] args) {
        int[] a = {2,3,1,7,6,4,5};
        MaxHeap heap = new MaxHeap(a);
        System.out.println(Arrays.toString(heap.array));
        /*
        算法描述
            1.heapify建立大顶堆
            2.将堆顶与堆底交换（最大元素被交换到堆底），缩小并下潜调整堆
            3.重复第二步直至堆里剩一个元素
         */
        while (heap.size > 1) {
            heap.swap(0, heap.size - 1);
            heap.size--;
            heap.down(0);
        }
        System.out.println(Arrays.toString(heap.array));
    }

}
