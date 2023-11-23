package com.qi;

public class ErFen {
    /**
     * 二分查找基础版
     *
     * @return 找到返回索引值，找不到返回-1
     */
    public static int binarySearchBasic(int[] a, int target) {
        int i = 0, j = a.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (target > a[m]) { //目标在右边
                i = m + 1;
            } else if (target < a[m]) { //目标在左边
                j = m - 1;
            } else {
                return m;
            }
        }
        return -1;
    }
    public static int binarySearchBLeft(int[] a, int target) {
        int i = 0, j = a.length - 1,candidate = -1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (target > a[m]) { //目标在右边
                i = m + 1;
            } else if (target < a[m]) { //目标在左边
                j = m - 1;
            } else {
                //先临时记录查找到的值
                candidate = m;
                j = m - 1;
                return candidate;
            }
        }
        return -1;
    }
}
