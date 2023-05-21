package com.hspedu.Spring.bean;

/**
 * ClassName: Dept
 * Package: com.hspedu.Spring.bean
 *
 * @Author: leikooo
 * @Creat: 2023/5/18 - 21:43
 * @Description:
 */
public class Dept {
    private String name;

    public Dept() {
        System.out.println("dep构造器");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "name='" + name + '\'' +
                '}';
    }
}
