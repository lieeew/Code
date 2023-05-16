package com.secondTest;

/**
 * @Author: qxy
 * @Date: 2023/2/5
 * @Description:
 */


public class ClassTest{
    String str = new String("hello");
    char[] ch = {'a','b','c'};
    public void fun(String str, char ch[]){
        str="world";
        ch[0]='d';
    }
    public static void main(String[] args) {
        ClassTest test1 = new ClassTest();
        test1.fun(test1.str,test1.ch);
        System.out.print(test1.str + " and "); // hello and  dbc
        System.out.print(test1.ch);
    }
}
