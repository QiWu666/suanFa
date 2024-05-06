package com.qi.paixu;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {
    /**
     * 切分
     * @param a1 数组
     * @param left 边界范围
     * @param right 最右侧索引
     */

    private static void split(int[] a1, int left, int right) {
        System.out.println(Arrays.toString(Arrays.copyOfRange(a1, left, right + 1)));
        // 结束条件
        if (left == right) {
            return;
        }
        // 中间点
        int m = (left + right) >>> 1;
        split(a1, left, m);
        split(a1, m + 1, right);
    }

    // TODO 2-p53 两数组合并方法
    public static void merge() {

    }


    public static void main(String[] args) {
        int[] a = {9, 4, 3, 6, 8, 1, 11, 7};
        soft(a);
        System.out.println(Arrays.toString(a));
    }

    private static void soft(int[] a) {
        split(a, 0, a.length - 1);
    }
}
