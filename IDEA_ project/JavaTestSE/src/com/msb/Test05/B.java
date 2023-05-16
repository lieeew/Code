package com.msb.Test05;

import com.msb.Test04.A;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/4 - 08 - 04
 * @Description: com.msb.Test05
 */
public class B extends A {
    public void a  () {
        System.out.println(age);
    }

    public static void main(String[] args) {
        A m = new A ();
        m.setAge(20);
        int a = m.getAge();
        System.out.println (a);
    }
}
