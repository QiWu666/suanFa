package com.qi;

public class DiGuiErFen {
    public static int search(int[] a, int target) {
        return f(a, target, 0, a.length - 1);
    }

    private static int f(int[] a, int target, int i, int j) {
        if (i > j) {
            return -1;
        }
        int m = (i + j) >>> 1;
        if (a[m] > target) {
            return f(a, target, i, m-1);
        } else if (a[m] < target) {
            return f(a, target, m+1, j);
        } else {
            return m;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 99};
        System.out.println(DiGuiErFen.search(a, 7));
    }
}
