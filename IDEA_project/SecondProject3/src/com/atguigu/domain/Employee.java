package com.atguigu.domain;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/10/5 - 10 - 05
 * @Description: com.atguigu.domain
 */
public class Employee {
    private int age;
    private String name;
    private int id;
    private double salary;

    public Employee() {
    }

    public Employee(int age, String name, int id, double salary) {
        this.age = age;
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }



    public String getDetail() {
        return id + "\t" + name + "\t" + age + "\t" + salary;
    }


    @Override
    public String toString() {
        return getDetail();
    }
}
