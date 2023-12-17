package com.qi.queue.test.likou.a703;

import com.qi.heap.leet.a703.Demo1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Demo1Test {

    private Demo1 demo1;

    @BeforeEach
    public void setUp() {
        int k = 3;
        int[] nums = {1, 2, 3, 4, 5};
        demo1 = new Demo1(k, nums);
    }

    @Test
    public void testAdd() {
        int val1 = demo1.add(6);
        Assertions.assertEquals(4, val1);

        int val2 = demo1.add(7);
        Assertions.assertEquals(5, val2);

        int val3 = demo1.add(8);
        Assertions.assertEquals(6, val3);
    }

}
