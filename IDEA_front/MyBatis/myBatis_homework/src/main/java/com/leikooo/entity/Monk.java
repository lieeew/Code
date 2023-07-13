package com.leikooo.entity;

import java.sql.Timestamp;
import java.util.Date;

public class Monk {
    private int id;
    private String nickname;
    private String skill;
    private int grade;
    private double salary;
    private Timestamp birthday;
    private Date entertime;

    public Monk() {
    }

    public Monk(int id, String nickname, String skill, int grade, double salary, Timestamp birthday, Date entertime) {
        this.id = id;
        this.nickname = nickname;
        this.skill = skill;
        this.grade = grade;
        this.salary = salary;
        this.birthday = birthday;
        this.entertime = entertime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }

    public Date getEntertime() {
        return entertime;
    }

    public void setEntertime(Date entertime) {
        this.entertime = entertime;
    }

    @Override
    public String toString() {
        return "Monk{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", skill='" + skill + '\'' +
                ", grade=" + grade +
                ", salary=" + salary +
                ", birthday=" + birthday +
                ", entertime=" + entertime +
                '}';
    }
}
