package com.qi;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ErFenTest {
    @Test
    @DisplayName("测试1")
    void test() {
        int[] a = {1, 3, 6, 34, 54, 87, 89, 90};
        //System.out.println(ErFen.binarySearchBasic(a, 6));
        Assertions.assertEquals(-1,ErFen.binarySearchBasic(a, 7));

    }

    @Test
    void testGaiLiang() {

        int[] a = {1, 3, 6, 34, 54, 87, 89, 90};
        //System.out.println(ErFen.binarySearchBasic(a, 6));
        Assertions.assertEquals(-1,ErFenGaiLiang.binarySearchBasic(a, 7));
        Assertions.assertEquals(2,ErFenGaiLiang.binarySearchBasic(a, 6));
        //Assertions.assertEquals(0,ErFenGaiLiang.binarySearchBasic(a, 1));
        Assertions.assertEquals(1,ErFenGaiLiang.binarySearchBasic(a, 3));
        Assertions.assertEquals(3,ErFenGaiLiang.binarySearchBasic(a, 34));
    }
    @Test
    void testBalance() {

        int[] a = {1, 3, 6, 34, 54, 87, 89, 90};
        //System.out.println(ErFen.binarySearchBasic(a, 6));
        Assertions.assertEquals(-1,BalanceBinarySearch.balanceBinarySearch(a, 7));
        Assertions.assertEquals(4,BalanceBinarySearch.balanceBinarySearch(a, 54));
        Assertions.assertEquals(5,BalanceBinarySearch.balanceBinarySearch(a, 87));
        Assertions.assertEquals(6,BalanceBinarySearch.balanceBinarySearch(a, 89));
        Assertions.assertEquals(7,BalanceBinarySearch.balanceBinarySearch(a, 90));
        //Assertions.assertEquals(2,BalanceBinarySearch.balanceBinarySearch(a, 6));
        Assertions.assertEquals(0,ErFenGaiLiang.binarySearchBasic(a, 1));
        Assertions.assertEquals(1,BalanceBinarySearch.balanceBinarySearch(a, 3));
        //Assertions.assertEquals(3,BalanceBinarySearch.balanceBinarySearch(a, 34));
    }

    @Test
    void testLeft() {

        int[] a = {1, 4, 5, 7, 8, 8, 8, 9, 10};
        Assertions.assertEquals(0, ErFen.binarySearchBLeft(a, 1));
        Assertions.assertEquals(1, ErFen.binarySearchBLeft(a, 4));
        Assertions.assertEquals(2, ErFen.binarySearchBLeft(a, 5));
        Assertions.assertEquals(3, ErFen.binarySearchBLeft(a, 7));
        Assertions.assertEquals(4, ErFen.binarySearchBLeft(a, 8));
        Assertions.assertEquals(7, ErFen.binarySearchBLeft(a, 9));
        Assertions.assertEquals(8, ErFen.binarySearchBLeft(a, 10));
    }
}
