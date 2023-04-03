package com.hspedu.Test.A;

/**
 * @Author: qxy
 * @Date: 2023/4/3
 * @Description:
 */
public class AnonymousInnerDetail {
    public static void main(String[] args) {
        new Outer05().f1();
    }
}


class Outer05 {

   public void f1() {
       new Person() {
           @Override
           public void hi() {
               System.out.println("hi() ~");
           }
       }.hi();



   }
}

class Person {

    public void hi() {
        System.out.println("hi() ~");
    }
}