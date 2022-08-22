package com.atguigu.p2.bean;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/21 - 08 - 21
 * @Description: com.atguigu.p2.bean
 */
public class Customer {
    private String name;
    private int age;
    private String sex;
    private String phone;
    private String email;
    public void setName (String name) {
        this.name = name;
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
    public void setSex (String sex) {
        this.sex = sex;
    }
    public String getSex () {
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
