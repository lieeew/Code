package com.hspedu.Monster;

/**
 * @Author: qxy
 * @Date: 2023/3/19
 * @Description:
 */
public class Monster {
    private int id;
    private String name;
    private String skill;

    public Monster() {
    }

    public Monster(int id, String name, String skill) {
        this.id = id;
        this.name = name;
        this.skill = skill;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "Monster{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", skill='" + skill + '\'' +
                '}';
    }
}
