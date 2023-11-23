package com.qi;

import org.junit.Test;

public class InsertSoftTest {
    @Test
    public void testInsert() {
        int[] arr = {2, 3, 4, 5, 6};
        InsertSoft.soft(arr);
        for (int a : arr) {
            System.out.println(a);
        }
    }
}
