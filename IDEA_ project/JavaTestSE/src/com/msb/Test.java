package com.msb;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/7/29 - 07 - 29
 * @Description: com.msb
 */
public class Test {
    public static void main(String[] args) {
        Person zs = new Person();
        zs.name = "张三";
        zs.height = 18.0;
        zs.weight = 120.3;
        zs.age = 20;
        Person LS = new Person();
        LS.age = 10;
        LS.weight = 100.0;
        LS.name = "理事";
        LS.height = 17.0;
        // 属性是独立的,方法是共用的;
        System.out.println(zs.name);
        zs.sleep("家");
        zs.eat();
        LS.eat();
        System.out.println(LS.introduce());


    }


}
