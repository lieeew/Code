package com.hspedu.web.json.entity;

/**
 * @author leikooo
 * @create 2023-06-24 17:16
 * @Package com.hspedu.web.json.entity
 * @Description
 */
public class Dog {
    private String name;
    private String address;

    public Dog() {
    }

    public Dog(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
