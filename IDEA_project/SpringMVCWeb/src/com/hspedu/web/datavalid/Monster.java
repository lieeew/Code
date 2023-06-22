package com.hspedu.web.datavalid;

/**
 * @author leikooo
 * @create 2023-06-22 19:32
 * @Package com.hspedu.web.datavalid
 * @Description
 */
public class Monster {
    private Integer id;
    private String email;
    private Integer age;
    private String name;

    public Monster() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Monster{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
