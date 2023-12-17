package com.qi.zhan;

import com.qi.zhan.impl.LinkedListStack;

public class InfixToSuffix {
    /*
    |   |
    |   |
    | *  |
    | +  |
    |_ _|
        a+b/c       -> abc/+
        a*b+c       -> ab*c+
        a+b*c       -> abc*+
        a+b*c-d     -> abc*+d-

     */


    /*
        1.遇到非运算符直接拼串
        2.遇到运算符时：
            如果运算符栈为空，直接将运算符入栈。
            如果运算符栈不为空，比较当前运算符与栈顶运算符的优先级。
            如果当前运算符优先级高，将当前运算符入栈。
            否则(等于或者小于)，将栈顶运算符弹出并输出，然后继续比较。
        3.遍历完成，栈里剩余运算符依次出栈
        4.带()
            左括号直接入栈，左括号优先设置为0
            右括号就把栈里到左括号为止的所有运算符出校
     */
    static int priority(char c) {
        return switch (c) {
            case '*', '/' -> 2;
            case '+', '-' -> 1;
            case '(' -> 0;
            default -> throw new RuntimeException("不合法的运算符" + c);
        };
    }

    static String infixToSuffix(String exp) {
        LinkedListStack<Character> stack = new LinkedListStack<>(exp.length());
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            switch (c) {
                case '+', '-', '*', '/' -> {
                    if (stack.isEmpty()) {
                        stack.push(c);
                    } else {
                        if (priority(c) > priority(stack.peek())) {
                            stack.push(c);
                        } else {
                            while (!stack.isEmpty()
                                    && priority(stack.peek()) >= priority(c)) {
                                result.append(stack.pop());
                            }
                            stack.push(c);
                        }
                    }
                }
                case '(' -> {
                    stack.push(c);
                }
                case ')' ->{
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        result.append(stack.pop());
                    }
                    stack.pop();
                }
                default -> result.append(c);
            }
        }
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return String.valueOf(result);
    }
}
