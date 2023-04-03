package com.hspedu.Test.A;

/**
 * @Author: qxy
 * @Date: 2023/4/3
 * @Description:
 */
public class AnonymousInnerClass {
    public static void main(String[] args) {
        Outer04 outer04 = new Outer04();
        outer04.method();

    }
}

class Outer04{
    private int n1 = 10;
    public void method() {
        // 基于接口的匿名内部类
        // 1. 需求使用 接口IA接口, 并创建对象
        // 2. 以后只想用一次, 后面不在使用
        // 3. 可以使用匿名实现类
        // 4. 匿名内部类的名字就是 : class com.hspedu.Test.A.Outter04$1
        // 5. jdk底层在创建匿名内部类Outer4$1 实例, 并且把地址返回给tiger


//        Tiger tiger = new Tiger();
//        tiger.cry();
        IA ia = new IA() {
            @Override
            public void cry() {
                System.out.println("老虎嗷嗷叫~~");
            }
        };
        // 运行类型是 class com.hspedu.Test.A.Outter04$1
        System.out.println("tiger的运行类型是 = " + ia.getClass());
        ia.cry();

        // 这里会把"Jack" 传递给 Father的构造器
        Father father = new Father("jack") {
            @Override
            public void test() {
                System.out.println("内部重写了构造器~~");
            }
        };
        System.out.println("father = " + father.getClass());
        father.test();
    }
}
interface IA {
    void cry();
}

//class Tiger implements IA {
//
//    @Override
//    public void cry() {
//        System.out.println("老虎嗷嗷叫~~");
//    }
//}

class Father {
    public Father(String name) {
        super();
        System.out.println("name = " + name);
    }

    public void test() {

    }
}