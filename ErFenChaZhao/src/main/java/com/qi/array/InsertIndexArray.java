package com.qi.array;

import java.util.Arrays;

public class InsertIndexArray {
    public static void testInsertArray(int[] a, int target) {
        int insertIndex = Arrays.binarySearch(a, 3);
        int[] b = null;
        System.out.println(insertIndex);
        if (insertIndex < 0) {
            b = new int[a.length + 1];
            int insertIndexAbs = Math.abs(insertIndex + 1);
            System.arraycopy(a, 0, b, 0, insertIndexAbs);
            b[insertIndexAbs] = target;
            System.arraycopy(a, insertIndexAbs, b, insertIndexAbs + 1, a.length - insertIndexAbs);
            System.out.println(Arrays.toString(b));
        }
    }
}
