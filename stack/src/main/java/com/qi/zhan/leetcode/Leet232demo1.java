package com.qi.zhan.leetcode;

import com.qi.zhan.impl.ArrayStack;

/**
 * 两个栈模拟一个队列
 */
public class Leet232demo1 {
    ArrayStack<Integer> s1 = new ArrayStack<Integer>(100);
    ArrayStack<Integer> s2 = new ArrayStack<Integer>(100);

    /**
     * 队列尾添加
         * s2.push(a)
         * s2.push(b)
     * 队列头移除
         * 先把 s2 的所有元素移动到 s1
         * s1.pop()
     * 向队列尾部添加
     */
    public void push(int x) {
        s2.push(x);
    }

    /**
     * 从队列头删除
     */
    public int pop() {
        if (s1.isEmpty()) {
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }
        return s1.pop();
    }

    /**
     * 从队列中获取头元素
     */
    public int peek() {
        if (s1.isEmpty()) {
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }
        return s1.peek();
    }

    public boolean empty() {
        return s2.isEmpty() && s1.isEmpty();
    }
}
