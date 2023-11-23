package com.qi;

import org.junit.Test;

public class DynamicTest {
    @Test
    public void test1() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.addLast(5);
        dynamicArray.get(2);
        dynamicArray.add(3,9);
        dynamicArray.foreach();
    }

    @Test
    public void testRemove() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.addLast(5);
        System.out.println(dynamicArray.remove(4));
        System.out.println(dynamicArray.remove(3));
    }

    @Test
    public void testCheckAndGrow() {
        DynamicArray dynamicArray = new DynamicArray();
        for (int i = 0; i < 11; i++) {
            dynamicArray.addLast(i + 1);
        }
        dynamicArray.foreach();
    }

}
