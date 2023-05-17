package com.atguigu.team.domain;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/28 - 09 - 28
 * @Description: com.atguigu.team.domain
 */
public class Designer extends Programmer{
    private double bonus; // 奖金
    private String id;

    public Designer() {
    }

    public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return getDetails() + "\t\t设计师\t" + getStatus() + "\t" +
                getBonus() +"\t\t\t\t" + getEquipment().getDescription();
    }

    public String getDetailTeamView() {
        return mermberId + "/" + getId() + "\t" + getName() + "\t" + getAge() + getSalary() + "\t设计师\t" + bonus;
    }


}
