package com.sgg.domain;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/1 - 11 - 01
 * @Description: com.sgg.domain
 */
public class Architect extends Designer {
    private int stock;

    public Architect(int id, String name, double salary, int age, Equipment equipment, double bonus, int stock) {
        super(id, name, salary, age, equipment, bonus);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return getMemberId() + "\t架构师\t" +
                getBonus() + "\t" + getStock();
    }

    @Override
    public String toString() {
        return getDetails() + "\t架构师\t" + getStatus() + "\t" +
                getBonus() + "\t\t" + getStock() + "\t" + getEquipment().getDescription();
    }

    public String getDetailTeamView() {
        return getMemberId() + "/" + getId() + "\t\t" + getName() + "\t" + getAge()  + "\t\t" + getSalary() + "\t\t设计师\t" + getBonus() + "\t\t" + stock;
    }
}
