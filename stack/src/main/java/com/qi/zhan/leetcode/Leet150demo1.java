package com.qi.zhan.leetcode;

import com.qi.zhan.impl.LinkedListStack;

public class Leet150demo1 {
    public int evalRPN(String[] tokens) {
        LinkedListStack<Integer> stack = new LinkedListStack<>(tokens.length);
        for (String token : tokens) {
            switch (token) {
                case "+" -> {
                    Integer b = stack.pop();
                    Integer a = stack.pop();
                    stack.push(a + b);
                }
                case "-" -> {
                    Integer b = stack.pop();
                    Integer a = stack.pop();
                    stack.push(a - b);
                }
                case "*" -> {
                    Integer b = stack.pop();
                    Integer a = stack.pop();
                    stack.push(a * b);
                }
                case "/" -> {
                    Integer b = stack.pop();
                    Integer a = stack.pop();
                    stack.push(a / b);
                }
                default -> {
                    stack.push(Integer.valueOf(token));
                }
            }
        }
        return stack.pop();
    }
}
