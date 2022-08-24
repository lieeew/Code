package com.atguigu.p2.bean;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/21 - 08 - 21
 * @Description: com.atguigu.p2.bean
 */
public class Customer {
    private String name;
    private int age;
    private char sex;
    private String phone;
    private String email;
    public Customer () {

    }
    public Customer (String name,char sex, int age, String email) {
        this.email = email;
        this.age = age;
        this.name = name;
    }
    public void setName (String name, char gender, int age, String phone) {
        this.name = name;
        this.age  = age;
        this.sex = sex;
        this.email = email;
    }
    public String getName () {
        return name;
    }
    public void setAge (int age) {
        this.age = age;
    }
    public int getAge () {
        return age;
    }
    public void setSex (char sex) {
        this.sex = sex;
    }
    public char getSex () {
        return sex;
    }
    public void setPhone (String phone) {
        this.phone = phone;
    }
    public String getPhone () {
        return phone;
    }
    public void setEmail (String email) {
        this.email = email;
    }
    public String getEmail () {
        return email;
    }


}
