package com.qi.heap.leet.a215;

import com.qi.heap.MinHeap;

/**
 * 解体思路
 * 1.向小顶堆放入前k个元素
 * 2.剩余元素
 *  - 若<=堆顶元素，则略过
 *  - 若>堆顶元素，则替换堆顶元素
 * 3.这样小顶堆始终保留的是到目前为止，前K大的元素
 * 4.循环结束，堆顶元素即为第K大元素
 */
public class Demo1 {
    public int findKthLargest(int[] nums, int k) {
        MinHeap heap = new MinHeap(k);
        for (int i = 0; i < k; i++) {
            heap.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i]> heap.peek()) {
                heap.replace(nums[i]);
            }
        }
        return heap.peek();
    }

    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        int[] arr1 = {3, 2, 1, 5, 6, 4};
        int[] arr2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int r1 = demo1.findKthLargest(arr1, 2);
        int r2 = demo1.findKthLargest(arr2, 4);
        System.out.println(r1+" "+r2    );
    }
}
