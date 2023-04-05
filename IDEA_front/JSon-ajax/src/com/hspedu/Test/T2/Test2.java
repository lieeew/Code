package com.hspedu.Test.T2;

import com.hspedu.Test.T1.A;

/**
 * @Author: qxy
 * @Date: 2023/4/4
 * @Description:
 */
public class Test2 {
    public static void main(String[] args) {
        /*
            1. A类和Test2不在同一个包中, 就不能访问到A类的protected构造器
            2. new A() {} 是一个匿名内部类, 可以理解A类的子类
            3. new A() {} 匿名内部类, 是一个类所以有一个无参构造器, 根据Java基础无参构造器会默认地哦啊用super()
            4. 所以执行时会调用A类的protected方法
         */
        A a = new A() {
        };
        // a.getClass = class com.hspedu.Test.T2.Test2$1
        System.out.println("a.getClass = " + a.getClass());


    }
}
