package com.qi.zhan.impl;

import org.junit.Test;

import java.util.Iterator;
import java.util.Objects;

import static org.junit.Assert.*;

public class LinkedListStackTest<E> {

    @Test
    public void testPush() {
        LinkedListStack<Object> stack = new LinkedListStack<>(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        assertEquals(5, stack.size);
    }

    @Test
    public void testPop() {
        LinkedListStack<Object> stack = new LinkedListStack<>(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        assertEquals(5, stack.pop());
        assertEquals(4, stack.pop());
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPeek() {
        LinkedListStack<Object> stack = new LinkedListStack<>(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        assertEquals(5, stack.peek());
        assertEquals(5, stack.peek());
        assertEquals(5, stack.peek());
        assertEquals(5, stack.peek());
        assertEquals(5, stack.peek());
    }

    @Test
    public void testisEmpty() {
        LinkedListStack<Object> stack = new LinkedListStack<>(5);
        assertTrue(stack.isEmpty());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testIsFull() {
        LinkedListStack<Object> stack = new LinkedListStack<>(5);
        assertFalse(stack.isFull());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        assertFalse(stack.isFull());
        stack.push(5);
        assertTrue(stack.isFull());
    }

    @Test
    public void testIterator() {
        LinkedListStack<Object> stack = new LinkedListStack<>(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        Iterator<Object> iterator = stack.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(5, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(4, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(3, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(2, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testClear() {
        LinkedListStack<Object> stack = new LinkedListStack<>(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        assertFalse(stack.isEmpty());
    }
}

