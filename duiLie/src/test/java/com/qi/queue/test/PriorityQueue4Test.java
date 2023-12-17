package com.qi.queue.test;

import com.qi.priorityQueue.Entry;
import com.qi.priorityQueue.PriorityQueue2;
import com.qi.priorityQueue.PriorityQueue4;
import org.junit.Test;

public class PriorityQueue4Test {


    @Test
    public void testPeek() {
        PriorityQueue4<Entry> queue = new PriorityQueue4<>(5);
        queue.offer(new Entry(1,"t1"));
        queue.offer(new Entry(5,"t5"));
        queue.offer(new Entry(4,"t4"));
        queue.offer(new Entry(3,"t3"));
        queue.offer(new Entry(2,"t2"));
        for (int i = 0; i < 5; i++) {
            System.out.println(queue.poll());
        }
    }

}
