package com.qi;

public class BalanceBinarySearch {
    public static int balanceBinarySearch(int[] arr, int target) {
        int i = 0, j = arr.length;
        while (1 < j - i) {
            int m = (i + j) >>> 1;
            if (target < arr[m]) {
                j = m;
            } else {
                i = m;
            }
        }
        if (target == arr[i]) {
            return i;
        } else {
            return -1;
        }
    }
}
