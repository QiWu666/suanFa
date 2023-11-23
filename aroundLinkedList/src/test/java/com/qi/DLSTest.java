package com.qi;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class DLSTest {
    @Test
    public void testAddFirst() {
        DoubleLinkedListSentinel list = new DoubleLinkedListSentinel();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(5);
    }

    @Test
    public void testAddLast() {
        DoubleLinkedListSentinel list = new DoubleLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
    }

    @Test
    public void testOther() {
        DoubleLinkedListSentinel list = new DoubleLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.removeFirst();
        list.removeLast();
        try {
            System.in.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testRemoveByValue() {
        DoubleLinkedListSentinel list = new DoubleLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.removeByValue(6);
        try {
            System.in.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
