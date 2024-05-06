package com.qi.paixu;

import java.util.Arrays;

/**
 * 排序算法
 */
public class E05InsertionSort {
    public static void sort(int[] nums) {
        sort(nums, 1);
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 1};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * @param low 未排序的下边界(索引)
     */
    private static void sort(int[] nums, int low) {
        if (nums.length == low) {
            return;
        }
        int t = nums[low]; // 把当前下标的值作为缓存
        int i = low - 1; // 已排序的指针
        while (i >= 0 && nums[i] > t) { // 没有找到插入位置
            nums[i + 1] = nums[i];
            i--;
        }
        // 找到插入位置
        nums[i + 1] = t;
        sort(nums, low + 1);
    }
}
