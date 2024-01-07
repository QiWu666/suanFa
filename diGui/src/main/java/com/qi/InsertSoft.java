package com.qi;

public class InsertSoft {
    // TODO p50算法
    public static void soft(int[] a) {
        insertion(a, 1);
    }
    public static void soft2(int[] a) {
        insertion2(a, 1);
    }

    /**
     * @param low 没有排序的右边界
     */
    private static void insertion(int[] a, int low) {
        if (low == a.length) {
            return;
        }
        // 没有排序的第一个元素
        int t = a[low];
        int i = low - 1; // 已经排序的指针位置
        while (i >= 0 && a[i] > t) {
            a[i + 1] = a[i];
            i--;
        }
        if (i + 1 != low) {
            a[i + 1] = t;
        }
        insertion(a, low + 1);
    }
    private static void insertion2(int[] a, int low) {
        if (low == a.length) {
            return;
        }
        int i = low - 1;//已经排序的指针位置
        while (i >= 0 && a[i] > a[i+1]) {
            int t = a[i];
            a[i] = a[i + 1];
            a[i + 1] = t;
            i--;
        }
        insertion(a, low + 1);
    }
}
