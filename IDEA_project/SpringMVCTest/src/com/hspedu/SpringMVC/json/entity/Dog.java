package com.hspedu.SpringMVC.json.entity;

/**
 * @author leikooo
 * @create 2023-06-26 17:10
 * @Package com.hspedu.SpringMVC.json.entity
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
