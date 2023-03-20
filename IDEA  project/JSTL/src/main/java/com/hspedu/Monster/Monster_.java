package com.hspedu.Monster;

/**
 * @Author: qxy
 * @Date: 2023/3/20
 * @Description:
 */
public class Monster_ {
    private Integer id;
    private String name;
    private String job;
    private Double sal;

    public Monster_() {
    }

    public Monster_(Integer id, String name, String job, Double sal) {
        this.id = id;
        this.name = name;
        this.job = job;
        this.sal = sal;
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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Double getSal() {
        return sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }

    @Override
    public String toString() {
        return "Monster_{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", sal=" + sal +
                '}';
    }
}
