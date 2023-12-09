package com.qi;

public class FeiBoNaQie {
    public static int f(int n) {
        if (n==1) {
            return 1;
        }
        if (n==0) {
            return 0;
        }
        int f = f(n - 1);
        int f2 = f(n - 2);
        return f + f2;
    }
}
