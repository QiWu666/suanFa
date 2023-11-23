package com.qi;

import org.junit.Assert;
import org.junit.Test;

public class DiDuiErFenTest {
    /**
     * 测试类
     */
    @Test
    public void testSearch() {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 99};
        Assert.assertEquals(6, DiGuiErFen.search(a, 7));
        Assert.assertEquals(-1, DiGuiErFen.search(a, 8));
        Assert.assertEquals(-1, DiGuiErFen.search(a, -1));
        Assert.assertEquals(7, DiGuiErFen.search(a, 99));
        Assert.assertEquals(-1, DiGuiErFen.search(a, 990));
    }
}
