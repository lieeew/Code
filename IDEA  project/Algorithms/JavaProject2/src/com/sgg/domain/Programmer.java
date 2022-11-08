package com.sgg.domain;

import com.sgg.view.Status;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/1 - 11 - 01
 * @Description: com.sgg.domain
 */
public class Programmer extends Employee implements Equipment{
    private int memberId;
    private Status status = Status.FREE;
    private Equipment equipment;

    public Programmer(int id, String name, double salary, int age, Equipment equipment) {
        super(id, name, salary, age);
        this.equipment = equipment;
    }


    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
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
    public String getDescription() {
        return getMemberId() + "\t程序员";
    }

    @Override
    public String toString() {
        return getDetails() + "\t程序员\t" + status +
                "\t\t\t\t\t\t" + equipment.getDescription() ;
    }

    public String getDetailTeamView() {
        return getMemberId() + "/" + getId() + "\t\t" + getName() + "\t" + getAge()  + "\t\t" + getSalary() + "\t\t程序员\t" ;
    }
}
