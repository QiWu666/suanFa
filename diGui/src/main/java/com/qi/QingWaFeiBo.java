package com.qi;

public class QingWaFeiBo {
    private static int f(int n) {
        if (n==0) {
            return 0;
        }
        n--;
        return f(n) + f(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(f(5));
    }
}
