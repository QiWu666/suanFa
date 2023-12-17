package com.qi.quene.leet;

import com.qi.quene.ArrayQueue3;

/**
 * 单队列模拟栈
 */
public class Leet255demo1 {
    ArrayQueue3<Integer> queue = new ArrayQueue3<Integer>(100);
    private int size = 0;

    /**
     * @param x 将元素 × 压入栈顶。
     */
    public void push(int x) {
            queue.offer(x);
        while (queue.peek() != x) {
            boolean offer = queue.offer(queue.poll());
        }
    }

    /**
     * @return 移除并返回栈顶元素
     */
    public int pop() {
        return queue.poll();
    }

    /**
     * @return 返回栈顶元素
     */
    public int top() {
        return queue.peek();
    }

    /**
     * @return 如果栈是空的，返回true；否则，返回false
     */
    public boolean empty() {
        return queue.empty();
    }
}
