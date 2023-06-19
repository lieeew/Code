package com.hspedu.entity;

/**
 * @author leikooo
 * @create 2023-06-15 12:05
 * @Package com.hspedu.entity
 * @Description  也有专门的 Lombok 通过注解生成构造器和 setter,getter 方法, 后面用
 */
public class Monster {
    private Integer id;
    private String name;
    private Integer age;
    private String skill;

    public Monster() {
    }

    public Monster(Integer id, String name, Integer age, String skill) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.skill = skill;

    }

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", skill='" + skill + '\'' +
                '}';
    }
}
