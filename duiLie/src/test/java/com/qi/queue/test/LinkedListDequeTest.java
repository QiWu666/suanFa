package com.qi.queue.test;

import com.qi.deque.LinkedListDeque;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.Optional;

import static org.junit.Assert.*;

public class LinkedListDequeTest {

    private LinkedListDeque<Integer> deque;

    @Before
    public void setUp() {
        deque = new LinkedListDeque<>(5);
    }

    @Test
    public void testOfferFirst() {
        deque.offerFirst(1);
        deque.offerFirst(2);
        deque.offerFirst(3);
        assertTrue(deque.offerFirst(4));
        assertTrue(deque.offerFirst(4));
        assertFalse(deque.offerFirst(5));
    }

    @Test
    public void testOfferLast() {
        deque.offerLast(1);
        deque.offerLast(2);
        deque.offerLast(3);
        assertTrue(deque.offerLast(4));
        assertTrue(deque.offerLast(4));
        assertFalse(deque.offerLast(5));
    }

    @Test
    public void testPollFirst() {
        deque.offerLast(1);
        deque.offerLast(2);
        deque.offerLast(3);
        deque.offerLast(4);
        assertEquals(1, deque.pollFirst().intValue());
        assertEquals(2, deque.pollFirst().intValue());
        assertEquals(3, deque.pollFirst().intValue());
        assertEquals(4, deque.pollFirst().intValue());
        assertNull(deque.pollFirst());
    }

    @Test
    public void testPollLast() {
        deque.offerLast(4);
        deque.offerLast(3);
        deque.offerLast(2);
        deque.offerLast(1);
        assertEquals(1, deque.pollLast().intValue());
        assertEquals(2, deque.pollLast().intValue());
        assertEquals(3, deque.pollLast().intValue());
        assertEquals(4, deque.pollLast().intValue());
        assertNull(deque.pollLast());
    }

    @Test
    public void testPeekFirst() {
        deque.offerLast(1);
        deque.offerLast(2);
        deque.offerLast(3);
        deque.offerLast(4);
        assertEquals(1, deque.peekFirst().intValue());
        assertEquals(1, deque.peekFirst().intValue());
        assertEquals(1, deque.peekFirst().intValue());
        assertEquals(1, deque.peekFirst().intValue());
    }

    @Test
    public void testPeekLast() {
        deque.offerLast(4);
        deque.offerLast(3);
        deque.offerLast(2);
        deque.offerLast(1);
        assertEquals(1, deque.peekLast().intValue());
        assertEquals(1, deque.peekLast().intValue());
        assertEquals(1, deque.peekLast().intValue());
        assertEquals(1, deque.peekLast().intValue());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(deque.isEmpty());
        deque.offerFirst(1);
        assertFalse(deque.isEmpty());
        deque.pollFirst();
        assertTrue(deque.isEmpty());
    }

    @Test
    public void testIsFull() {
        assertFalse(deque.isFull());
        deque.offerLast(1);
        assertFalse(deque.isFull());
        deque.offerLast(2);
        deque.offerLast(2);
        deque.offerLast(2);
        deque.offerLast(2);
        deque.offerLast(2);
        assertTrue(deque.isFull());
    }

    @Test
    public void testIterator() {
        deque.offerFirst(1);
        deque.offerFirst(2);
        deque.offerFirst(3);
        deque.offerLast(4);
        deque.offerLast(5);
        Iterator<Integer> iterator = deque.iterator();
        for (Iterator<Integer> it = iterator; it.hasNext(); ) {
            Integer i = it.next();
            System.out.println(i);
        }
    }
}

