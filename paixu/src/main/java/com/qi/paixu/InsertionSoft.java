package com.qi.paixu;

import java.util.Arrays;

/**
 * 插入排序算法 ,非递归 TODO 2-p51
 */
public class InsertionSoft {
    public static void soft(int[] a) {
        insertion(a, 1);
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 2, 4, 6, 8, 7};
        soft(a);
        System.out.println(Arrays.toString(a));
    }
    private static void insertion(int[] a, int low) {
        if (low == a.length) {
            return;
        }
        //没有排序的第一个元素
        int t = a[low];
        int i = low - 1;//已经排序的指针位置
        // 自右向左找插入位置,如果比待插入元素大，则不断右移，空出插入位置
        // 判断i的索引位置
        while (i >= 0 && a[i] > t) {
            a[i + 1] = a[i];
            i--;
        }
        if (i + 1 != low) {
            // 找到插入位置
            a[i + 1] = t;
        }
        insertion(a, low + 1);
    }

}
