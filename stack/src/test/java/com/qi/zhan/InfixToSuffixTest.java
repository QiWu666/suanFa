package com.qi.zhan;

import org.junit.Test;

import static com.qi.zhan.InfixToSuffix.infixToSuffix;
import static org.junit.Assert.assertEquals;

public class InfixToSuffixTest {


    @Test
    public void testInfixToSuffix() {
        String exp1 = "a+b/c";
        String expected1 = "abc/+";
        String result1 = infixToSuffix(exp1);
        assertEquals(expected1, result1);

        String exp2 = "a*b+c";
        String expected2 = "ab*c+";
        String result2 = infixToSuffix(exp2);
        assertEquals(expected2, result2);

        String exp3 = "a+b*c";
        String expected3 = "abc*+";
        String result3 = infixToSuffix(exp3);
        assertEquals(expected3, result3);

        String exp4 = "a+b*c-d";
        String expected4 = "abc*+d-";
        String result4 = infixToSuffix(exp4);
        assertEquals(expected4, result4);

        String exp5 = "(a+b)/c";
        String expected5 = "ab+c/";
        String result5 = infixToSuffix(exp5);
        assertEquals(expected5, result5);

        String exp6 = "a*(b+c)";
        String expected6 = "abc+*";
        String result6 = infixToSuffix(exp6);
        assertEquals(expected6, result6);

        String exp7 = "a+b*c-d/e";
        String expected7 = "abc*+de/-";
        String result7 = infixToSuffix(exp7);
        assertEquals(expected7, result7);

        String exp8 = "((a+b)+c)";
        String expected8 = "ab+c+";
        String result8 = infixToSuffix(exp8);
        assertEquals(expected8, result8);
    }
}

