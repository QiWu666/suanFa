package com.qi.queue.test;

import com.qi.quene.ArrayQueue3;
import org.junit.Test;

import java.util.Iterator;

public class TestArrayQueue3 {
    ArrayQueue3<Integer> queue1 = new ArrayQueue3<>(5);
    {
        queue1.offer(1);
        queue1.offer(2);
        queue1.offer(3);
        queue1.offer(4);
        queue1.offer(5);
    }


    @Test
    public void testFull() {
        System.out.println(queue1.isFull());
    }

    @Test
    public void testEmpty() {
        System.out.println(queue1.empty());
    }

    @Test
    public void testPeek() {
        System.out.println(queue1.peek());
    }

    @Test
    public void testPool() {
        System.out.println(queue1.poll());
        System.out.println(queue1.poll());
        System.out.println("--------上面是pool出来的元素--------------");
        Iterator<Integer> iterator = queue1.iterator();
        iterator.forEachRemaining(System.out::println);
    }
}
