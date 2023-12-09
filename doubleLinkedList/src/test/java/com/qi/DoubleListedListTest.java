package com.qi;

import org.junit.Test;

public class DoubleListedListTest {
    @Test
    public void testA() {
        DoubleLinkedList list = new DoubleLinkedList();
        list.insert(0, 111);
        list.insert(1, 222);
        list.insert(2, 333);
        list.insert(3, 444);
        list.insert(4, 555);
        list.foreach();
    }

    @Test
    public void testRemove() {
        DoubleLinkedList list = new DoubleLinkedList();
        list.insert(0, 111);
        list.insert(1, 222);
        list.insert(2, 333);
        list.insert(3, 444);
        list.insert(4, 555);
        list.removeLast();
        list.removeLast();
        list.removeFirst();
        list.addLast(666);
        for (int i : list) {
            System.out.println(i);
        }
    }
}
