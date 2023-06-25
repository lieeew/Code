package com.hspedu.web.json.entity;

/**
 * @author leikooo
 * @create 2023-06-25 6:12
 * @Package com.hspedu.web.json.entity
 * @Description
 */
public class User {
    private String userName;
    private Integer age;

    public User() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }
}
