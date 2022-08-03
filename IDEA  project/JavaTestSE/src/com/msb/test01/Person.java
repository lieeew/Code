package com.msb.test01;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/3 - 08 - 03
 * @Description: com.msb.test01
 */
public class Person {
    private int age;
    private String name;
    private String sex;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    public void eat () {
        System.out.println("吃饭");
    }
    public void drink () {
        System.out.println("喝水");
    }
}
