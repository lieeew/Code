package com.hspedu.entity;

/**
 * @Author: qxy
 * @Date: 2023/3/16
 * @Description:
 */
public class Monster {
    private String name;
    private Integer id;
    private String skill;

    public Monster() {
    }

    public Monster(String name, Integer id, String skill) {
        this.name = name;
        this.id = id;
        this.skill = skill;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
}
