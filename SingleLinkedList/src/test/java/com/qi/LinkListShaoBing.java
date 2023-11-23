package com.qi;

import com.qi.shaobing.SimplyLinkedListShaoBing;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LinkListShaoBing {
    @Test
    void test() {
        SimplyLinkedListShaoBing list = new SimplyLinkedListShaoBing();
//        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.loop();
    }

    @Test
    void testInsert() {
        SimplyLinkedListShaoBing list = new SimplyLinkedListShaoBing();
//        list.addLast(1);
        list.insert(0, 6);
        list.insert(1, 7);
        list.insert(2, 8);
        list.insert(3, 9);
        list.addLast(10);
        Assertions.assertIterableEquals(List.of(6,7,8,9,10), list);
    }

    @Test
    void testAddLast() {
        SimplyLinkedListShaoBing list = new SimplyLinkedListShaoBing();
        list.addLast(1);
        list.addFirst(0);
        list.loop();
        SimplyLinkedListShaoBing list2 = new SimplyLinkedListShaoBing();
        list2.addFirst(1);
        list2.foreach();
    }

    @Test
    void testRemove() {
        SimplyLinkedListShaoBing list = new SimplyLinkedListShaoBing();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addFirst(0);
        list.remove(2);
        Assertions.assertIterableEquals(List.of(0, 1, 3), list);
        Assertions.assertThrows(IllegalArgumentException.class, () -> list.remove(4));

    }
}
