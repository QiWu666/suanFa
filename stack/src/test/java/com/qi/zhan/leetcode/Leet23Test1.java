package com.qi.zhan.leetcode;

import com.qi.zhan.impl.ArrayStack;
import org.junit.Test;
import static org.junit.Assert.*;

public class Leet23Test1 {

    @Test
    public void testIsValid() {
        Leet23demo1 validParentheses = new Leet23demo1();
        assertTrue(validParentheses.isValid("()"));
        assertTrue(validParentheses.isValid("()[]{}"));
        assertFalse(validParentheses.isValid("(]"));
        assertFalse(validParentheses.isValid("([)]"));
        assertTrue(validParentheses.isValid("{[]}"));
        assertFalse(validParentheses.isValid("}{"));
    }
}

