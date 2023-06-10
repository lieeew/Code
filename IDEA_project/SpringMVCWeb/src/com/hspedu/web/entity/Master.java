package com.hspedu.web.entity;

/**
 * ClassName: Master
 * Package: com.hspedu.web.entity
 *
 * @Author: leikooo
 * @Creat: 2023/6/9 - 6:11
 * @Description:
 */
public class Master {
    private Integer id;
    private String name;
    private Pet pet;

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

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    @Override
    public String toString() {
        return "Master{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pet=" + pet +
                '}';
    }
}
