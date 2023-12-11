package com.qi.test;

import java.util.Scanner;

public class ssongjinbo {
    public static void main(String[] args) {
        String rigatUsername = "zhangsan";
        String rightpasserword = "123456";
        //键盘录入整数
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String usename = sc.next();
        System.out.println("请输入密码");
        String passreword = sc.next();
        if (usename.equals(rigatUsername) && passreword.equals(passreword)) {
            System.out.println("正确");

        } else {
            System.out.println("错误");
        }


    }
}
