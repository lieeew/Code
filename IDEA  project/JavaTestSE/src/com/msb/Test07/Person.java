package com.msb.Test07;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/4 - 08 - 04
 * @Description: com.msb.Test07
 */
public class Person {
    private int age = 20;
    private String name;
    private String sex;
    private void eat () { // 父类可以更加隐私
        System.out.println("吃饭");
    }
}
