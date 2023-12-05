package com.qi;

public class BubbleSoft1 {
    public static void soft(int[] a) {
        bubble(a, a.length - 1);
    }

    public static void soft1(int[] a) {
        bubble1(a, a.length - 1);
    }

    /**
     * 初版冒泡排序
     * @param a
     * @param j 区域右边界
     */
    private static void bubble(int[] a, int j) {
        if (j == 0) {
            return;
        }
        for (int i = 0; i < j; i++) {
            if (a[i] > a[i + 1]) {
                int t = a[i];
                a[i] = a[i + 1];
                a[i + 1] = t;
            }
        }
        bubble(a, j - 1);
    }

    /**
     * 优化版bubble
     * 如果两数组元素交换下标，就把i的值赋值给x
     * @param a
     * @param j
     */
    private static void bubble1(int[] a, int j) {
        if (j == 0) {
            return;
        }
        int x = 0;
        for (int i = 0; i < j; i++) {
            if (a[i] > a[i + 1]) {
                int t = a[i];
                a[i] = a[i + 1];
                a[i + 1] = t;
                x = i;
            }
        }
        bubble1(a, j - 1);
    }

}
