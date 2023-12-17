package com.qi.queue.test;

import com.qi.priorityQueue.Entry;
import com.qi.priorityQueue.PriorityQueue1;
import com.qi.priorityQueue.PriorityQueue2;
import org.junit.Test;

public class PriorityQueue2Test {


    @Test
    public void testPeek() {
        PriorityQueue2<Entry> queue = new PriorityQueue2<>(5);
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
