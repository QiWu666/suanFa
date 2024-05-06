package com.qi.paixu;

import java.util.Arrays;

/**
 * 希尔排序 TODO 2-p52
 */
public class ShellSort {
    public static void soft(int[] a) {
        // 希尔排序不断调整gap的间隙
        for (int gap = a.length >> 1; gap >= 1; gap = gap >> 1) {
            // gap = 4
            for (int low = gap; low < a.length; low++) {
                //没有排序的第一个元素
                int t = a[low];
                int i = low - gap;//已经排序的指针位置
                // 自右向左找插入位置,如果比待插入元素大，则不断右移，空出插入位置
                while (i >= 0 && a[i] > t) {
                    a[i + gap] = a[i];
                    i-=gap;
                }
                // 找到插入位置
                if (i + gap != low) {
                    a[i + gap] = t;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {8, 6, 5, 3, 1, 2, 9, 10};
        soft(a);
        System.out.println(Arrays.toString(a));
    }
}
