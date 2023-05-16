package com.sgg.domain;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/1 - 11 - 01
 * @Description: com.sgg.domain
 */
public class Designer extends Programmer{
    private double bonus;

    public Designer(int id, String name, double salary, int age, Equipment equipment, double bonus) {
        super(id, name, salary, age, equipment);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public String getDescription() {
        return getMemberId() + "\t设计师\t" + getBonus();
    }

    @Override
    public String toString() {
        return getDetails() + "\t设计师\t" + getStatus() + "\t" +
                getBonus() +"\t\t\t\t" + getEquipment().getDescription();
    }

    public String getDetailTeamView() {
        return getMemberId() + "/" + getId() + "\t\t" + getName() + "\t" + getAge()  + "\t\t" + getSalary() + "\t\t设计师\t" + getBonus();
    }
}
