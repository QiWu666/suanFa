package com.qi;

public class ErFenGaiLiang {
    public static int binarySearchBasic(int[] a, int target) {
        int i = 0, j = a.length;
        while (i < j) {
            int m = (i + j) >>> 1;
            if (target > a[m]) { //目标在右边
                i = m + 1;
            } else if (target < a[m]) { //目标在左边
                j = m; // j是数组的边界，不是要查找的目标
            } else {
                return m;
            }
        }
        return -1;
    }
}
