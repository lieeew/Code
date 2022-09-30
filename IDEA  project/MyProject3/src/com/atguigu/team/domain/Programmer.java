package com.atguigu.team.domain;

import com.atguigu.team.service.Status;


/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/28 - 09 - 28
 * @Description: com.atguigu.team.domain
 */
public class Programmer extends Employee{

    private int Architect; // 开发团队后在团队中的ID
    private Status status = Status.FREE; // 表示成员的状态
    private Equipment equipment; // 表示该成员领用的设备

    public Programmer() {
    }

    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    public int getArchitect() {
        return Architect;
    }

    public void setArchitect(int architect) {
        Architect = architect;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return getDetails() + "\t\t程序员\t" + status + "\t\t\t\t\t\t" + equipment.getDescription() ;
    }
}


