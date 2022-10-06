package com.atguigu.domain;

import com.atguigu.service.Status;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/10/5 - 10 - 05
 * @Description: com.atguigu.domain
 */
public class Programmer extends Employee{

    private int memberId;
    private Status status = Status.FREE;
    private Equipment equipment;

    public Programmer(int age, String name, int id, double salary, Equipment equipment) {
        super(age, name, id, salary);
        this.equipment = equipment;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return getDetail() + "\t程序员\t" + status + "\t\t\t" + equipment.getDescription() ;
    }
}
