package com.qi;

import com.qi.likou.a206.LiKou206demo2;
import org.junit.Test;
public class LiKou206Test2 {
    @Test
    void test() {
        LiKou206demo2.MyNode n1 = new LiKou206demo2.MyNode(1, null);
        LiKou206demo2.MyNode n2 = new LiKou206demo2.MyNode(2, n1);
        LiKou206demo2.MyNode n3 = new LiKou206demo2.MyNode(3, n2);
        LiKou206demo2.MyNode n4 = new LiKou206demo2.MyNode(4, n3);
        LiKou206demo2.MyNode n5 = new LiKou206demo2.MyNode(5, n4);
        //System.out.println(n5);
        LiKou206demo2 re = new LiKou206demo2();
        System.out.println(re.reverseList2(n5));
    }
}
