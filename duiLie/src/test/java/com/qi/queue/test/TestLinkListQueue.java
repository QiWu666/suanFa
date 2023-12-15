package com.qi.queue.test;

import com.qi.quene.LinkListQueue;
import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;

public class TestLinkListQueue {
    @org.junit.Test
    public void testOffer() {
        LinkListQueue<Integer> queue = new LinkListQueue<>();
        boolean offer = queue.offer(2);
        boolean offer2 = queue.offer(3);
        boolean offer3 = queue.offer(4);
        boolean offer4 = queue.offer(5);
        System.out.println(queue.peek());
        for (Integer integer : queue) {
            System.out.println(integer);
        }
        System.out.println(offer);
    }

    @Test
    public void testPoll() {
        LinkListQueue<Integer> queue = new LinkListQueue<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll();
        System.out.println(queue.empty());

    }

    @Test
    public void testIsFull() {
        LinkListQueue<Integer> queue = new LinkListQueue<>();
        System.out.println(queue.offer(1));
        queue.offer(1);
        queue.offer(1);
        queue.offer(1);
        queue.offer(1);
    }
}
