package com.qi.likou.a88gai;

import java.util.Arrays;

// TODO p90
public class LeetCode88Gai {
    /**
     * a1原始数组   a2结果数组(k)
     * i,iEnd第一个有序区间的起点终点，j,jEnd 第二个有序区间的起点终点
     */
    public static void merge(int[] a1, int i, int iEnd, int j, int jEnd, int[] a2, int k) {
        if (i > iEnd) {
            System.arraycopy(a1, j, a2, k, jEnd - j + 1);
            return;
        }
        if (j > jEnd) {
            System.arraycopy(a1, i, a2, k, iEnd - i + 1);
            return;
        }
        if (a1[i] < a1[j]) {
            a2[k] = a1[i];
            merge(a1, i + 1, iEnd, j, jEnd, a2, k + 1);
        }
        if (a1[i] > a1[j]) {
            a2[k] = a1[j];
            merge(a1, i, iEnd, j + 1, jEnd, a2, k + 1);
        }
    }

    public static void main(String[] args) {
        int[] a1 = {10, 12, 4, 2, 9, 1};
        int[] a2 = new int[a1.length];
        merge(a1, 0, 2, 3, 5, a2, 0);
        for (int i : a2) {
            System.out.println(i);
        }
    }
}
