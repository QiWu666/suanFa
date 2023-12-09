package com.qi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LinkTest {
    @Test
    void testAdd() {
        SimplyLinkedList list = new SimplyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.loop();
        for (int node : list) {
            System.out.println(node);
        }
    }

    @Test
    void testAddLast() {
        SimplyLinkedList list = new SimplyLinkedList();
//        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
//        list.loop();
        Assertions.assertIterableEquals(List.of(2,3,4,5),list);
    }
    @Test
    void testFind() {
        SimplyLinkedList list = new SimplyLinkedList();
//        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
//        list.loop();
        System.out.println(list.get(2));
    }

    @Test
    void testInsertIndex() {
        SimplyLinkedList list = new SimplyLinkedList();
//        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.insert(1,1);
        for (int a : list) {
            System.out.println(a);
        }
        System.out.println(list.get(1));
    }

    @Test
    void testRemoveList() {
        SimplyLinkedList list = new SimplyLinkedList();
//        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
//        list.removeFirst();
    }

    @Test
    void testRecursion() {
        SimplyLinkedList list = new SimplyLinkedList();
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.loopRecursion(b->{
            System.out.println(b);
        }, a-> System.out.println(a));
    }
}
