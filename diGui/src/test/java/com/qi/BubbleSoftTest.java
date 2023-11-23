package com.qi;

import org.junit.Test;

public class BubbleSoftTest {
    @Test
    public void testBubbleTest() {
        int[] a = {6, 5, 4, 3, 2, 1};
        int[] b = {432, 234, 123, 7, 6, 5, 4, 3, 2, 1};
        BubbleSoft1.soft(a);
        for (int j : a) {
            System.out.println(j);
        }
        System.out.println("=====================");
        BubbleSoft1.soft(b);
        for (int j : b) {
            System.out.println(j);
        }
    }
    @Test
    public void testBubbleTest2() {
        int[] a = {6, 5, 4, 3, 2, 1};
        int[] b = {432, 234, 123, 7, 6, 5, 4, 3, 2, 1};
        BubbleSoft1.soft1(a);
        for (int j : a) {
            System.out.println(j);
        }
        System.out.println("=====================");
        BubbleSoft1.soft1(b);
        for (int j : b) {
            System.out.println(j);
        }
    }
}
