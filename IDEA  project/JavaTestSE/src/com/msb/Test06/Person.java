package com.msb.Test06;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/4 - 08 - 04
 * @Description: com.msb.Test06
 */
public class Person {
    private int age;
    private String name;
    private String sex;
    public Person () {

    }
    public Person eat () {
        System.out.println("吃饭");
        return new Person();
    }

}
