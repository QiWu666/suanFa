package com.qi.heap.leet.a703;

import com.qi.heap.MinHeap;

/**
 * 求数据流中第K大的元素
 */
public class Demo1 {
    private MinHeap heap;
    public Demo1(int k, int[] nums) {
        heap = new MinHeap(k);
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (!heap.isFull()) {
            heap.offer(val);
        } else if (val > heap.peek()) {
            heap.replace(val);
        }
        return heap.peek();
    }

    public static void main(String[] args) {

    }
}
