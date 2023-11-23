package com.qi;

public class ErFenLeft2 {
    /**
     * 变形二分查找
     * @param a
     * @param target
     * @return
     */
    public static int binarySearchBLeft2(int[] a, int target) {
        int i = 0, j = a.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (target > a[m]) { //目标在右边
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return i;
    }
}
