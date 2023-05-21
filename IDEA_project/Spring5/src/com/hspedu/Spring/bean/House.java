package com.hspedu.Spring.bean;

/**
 * ClassName: House
 * Package: com.hspedu.Spring.bean
 *
 * @Author: leikooo
 * @Creat: 2023/5/20 - 15:23
 * @Description:
 */
public class House {
    private String name;
    public House() {
        System.out.println("House() 构造器");
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        System.out.println("House setName()...");
        this.name = name;
    }
    // 老师说明, 这个发明是有程序员编写的
    // 根据自己的业务逻辑
    // 名子不是固定的
    public void init() {
        System.out.println("House init()..");
    }

    // 老师说明, 这个发明是有程序员编写的
    // 根据自己的业务逻辑
    // 名子不是固定的
    public void destory() {
        System.out.println("House destory()..");
    }

    @Override
    public String toString() {
        return "House{" +
                "name='" + name + '\'' +
                '}';
    }
}
