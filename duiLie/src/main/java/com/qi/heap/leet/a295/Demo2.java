package com.qi.heap.leet.a295;

import java.util.PriorityQueue;

public class Demo2 {
    // 大顶堆
    private final PriorityQueue<Integer> left = new PriorityQueue<>(
            (a, b) -> Integer.compare(b, a)
    );
    // 小顶堆
    private final PriorityQueue<Integer> right = new PriorityQueue<>();

    public void addNum(int num) {
        if (left.size()== right.size()) {
            right.offer(num);
            left.offer(right.poll());
        }else {
            left.offer(num);
            right.offer(left.poll());
        }
    }

    public double findMedian() {
        if (left.size() == right.size()) {
            return (left.peek() + right.peek()) / 2.0;
        }
        return left.peek();
    }
}
