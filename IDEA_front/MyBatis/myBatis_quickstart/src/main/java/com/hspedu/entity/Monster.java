package com.hspedu.entity;

import java.util.Date;

/**
 * @author leikooo
 * @create 2023-07-01 8:41
 * @Package coom.hspedu.entity
 * @Description 和 Monster 表有对应关系
 * 1. 使用原生态的 sql 语句查询结果还是要封装成对象
 * 2. 要求大家这里的实体类属性名和表名字段保持一致。
 */
public class Monster {
    // 属性和表的字段一一对应
    private Integer id;
    private Integer age;
    private Date  birthday;
    private String name;
    private String email;
    private Double salary;
    private Integer gender;

    public Monster() {
    }

    public Monster(Integer id, Integer age, Date birthday, String name, String email, Double salary, Integer gender) {
        this.id = id;
        this.age = age;
        this.birthday = birthday;
        this.name = name;
        this.email = email;
        this.salary = salary;
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Monster{" +
                "id=" + id +
                ", age=" + age +
                ", birthday=" + birthday +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                ", gender=" + gender +
                '}';
    }
}
