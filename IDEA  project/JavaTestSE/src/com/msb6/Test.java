package com.msb6;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/7/31 - 07 - 31
 * @Description: com.msb6
 */
public class Test {
    // 属性
    int a;
    static int sa = 10;
    // 方法
    public void a () {
        System.out.println("这是一个方法");
        {
            System.out.println("这是一个代码块");
        }
    }
    public static void b () {

        System.out.println("java");
    }
    // 空构造器
    public Test () {
        System.out.println("这是空构造器");
    }
    {
        System.out.println(a);
    }
    // 有参构造器
    public Test (int a) {
        this.a = a;
    }
    {
        System.out.println("这是构造块");
    }

    // 这是程序的入口
    public static void main(String[] args) {
        Test t = new Test(10);
        t.a();
        Test.b();

    }
}
