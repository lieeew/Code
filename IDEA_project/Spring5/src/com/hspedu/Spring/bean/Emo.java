package com.hspedu.Spring.bean;

/**
 * ClassName: Emo
 * Package: com.hspedu.Spring.bean
 *
 * @Author: leikooo
 * @Creat: 2023/5/18 - 21:44
 * @Description:
 */
public class Emo {
    private String name;
    private Dept dept;

    public Emo() {
    }

    public Emo(String name, Dept dept) {
        this.name = name;
        this.dept = dept;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Emo{" +
                "name='" + name + '\'' +
                ", dept=" + dept +
                '}';
    }
}
