package com.qi.queue.test;

import com.qi.priorityQueue.Entry;
import com.qi.priorityQueue.PriorityQueue1;
import org.junit.Test;
import static org.junit.Assert.*;

public class PriorityQueue1Test {


    @Test
    public void testPeek() {
        PriorityQueue1<Entry> queue = new PriorityQueue1<>(5);
        queue.offer(new Entry(1,"a"));
        queue.offer(new Entry(2,"b"));
        queue.offer(new Entry(3,"v"));
        queue.offer(new Entry(4,"c"));
        queue.offer(new Entry(5,"x"));
        for (int i = 0; i < 6; i++) {
            System.out.println(queue.peek());
        }
    }

}
