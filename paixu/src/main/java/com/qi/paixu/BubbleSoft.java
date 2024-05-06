package com.qi.paixu;

import java.util.Arrays;

public class BubbleSoft {
    public static void main(String[] args) {
        int[] a = new int[]{6, 5, 4, 3, 2, 1};
        bubble(a);
        System.out.println(Arrays.toString(a));
    }

    public static void bubble(int[] a) {
        int j = a.length - 1;
        while (true) {
            int x = 0;
            for (int i = 0; i < j; i++) {
                if (a[i] > a[i + 1]) {
                    // 冒泡排序 元素两两比较
                    int t = a[i];    // a[i] 索引 分配给临时变量
                    a[i] = a[i + 1]; // a[i+1] 的值 赋值给 a[i]
                    a[i + 1] = t;    // a[i] 的值 赋值给 a[i+1]
                    x = i;
                }
            }
            j = x;
            if (j == 0) {
                return;
            }
        }
    }
}
