package com.hspedu.Spring.bean;

/**
 * ClassName: Cat
 * Package: com.hspedu.Spring.bean
 *
 * @Author: leikooo
 * @Creat: 2023/5/20 - 6:31
 * @Description:
 */
public class Cat {
    private String name;
    private Integer age;

    public Cat() {
        System.out.println("无参构造器被调用~");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
