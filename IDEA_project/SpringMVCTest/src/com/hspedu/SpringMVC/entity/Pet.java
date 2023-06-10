package com.hspedu.SpringMVC.entity;

/**
 * ClassName: Pet
 * Package: com.hspedu.web.entity
 *
 * @Author: leikooo
 * @Creat: 2023/6/9 - 6:12
 * @Description:
 */
public class Pet {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
