package com.qi.zhan.leetcode;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Leet150Test {

    @Test
    public void testEvalRPN() {
        Leet150demo1 demo = new Leet150demo1();

        // Test case 1
        String[] tokens1 = {"3", "4", "+", "2", "*"};
        int expectedResult1 = 14;
        int result1 = demo.evalRPN(tokens1);
        assertEquals(expectedResult1, result1);

        // Test case 2
        String[] tokens2 = {"3", "4", "5", "+", "-"};
        int expectedResult2 = -6 ;
        int result2 = demo.evalRPN(tokens2);
        assertEquals(expectedResult2, result2);

        // Test case 3
        String[] tokens3 = {"3", "4", "5", "*", "+"};
        int expectedResult3 = 23;
        int result3 = demo.evalRPN(tokens3);
        assertEquals(expectedResult3, result3);

        // Test case 4
        String[] tokens4 = {"4", "5", "/"};
        int expectedResult4 = 0;
        int result4 = demo.evalRPN(tokens4);
        assertEquals(expectedResult4, result4);
    }
}

