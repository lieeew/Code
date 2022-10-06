package com.atguigu.domain;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/10/6 - 10 - 06
 * @Description: com.atguigu.domain
 */
public class Designer extends Programmer{
    private double bonus;

    public Designer(int age, String name, int id, double salary , Equipment equipment, double bonus) {
        super(age, name, id, salary,  equipment);
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
        return getDetail() + "\t设计师\t" + getStatus() + "\t" +
                getBonus() +"\t\t" + getEquipment().getDescription();
    }
}
