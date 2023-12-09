package com.qi;

public class StringRevert {
    public static void main(String[] args) {
        String s = "abcdefg";
        revert(s, 0);
    }

    public static void revert(String str, int i) {
        if (i == str.length()) {
            return;
        }
        revert(str, i + 1);
        System.out.println(str.charAt(i));

    }
}
