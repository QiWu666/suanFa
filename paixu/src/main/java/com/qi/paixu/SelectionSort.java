package com.qi.paixu;

import java.util.Arrays;

/**
 * 选择排序算法
 */
public class SelectionSort {
    public static void sort(int[] nums) {
        // 1.选择轮数 a.length -1
        // 2.交换的索引位置(right) 初始 α.length - 1，每次递减
        for (int right = nums.length - 1; right > 0; right--) {
            int max = nums[right]; // 假设数组最右侧的值最大
            for (int i = 0; i < right; i++) {
                if (nums[i] > max) {
                    // 记录的是索引位置
                    max = i;
                }
            }
            if (max != right) {
                swap(nums, max, right);
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{5, 4, 3, 2, 1};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void swap(int[] a, int i, int j) {
        int t = a[i];
    }
}
