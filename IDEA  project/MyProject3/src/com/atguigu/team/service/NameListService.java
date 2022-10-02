package com.atguigu.team.service;

import com.atguigu.team.domain.*;

import static com.atguigu.team.service.Data.*;


/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/28 - 09 - 28
 * @Description: com.atguigu.team.service
 */
public class NameListService extends Employee {
    private Employee[] employees;

    public NameListService() {
        employees = new Employee[Data.EMPLOYEES.length];
        for (int a = 0; a < employees.length; a++) {
            // 获取Employee的基本信息
            int id = Integer.parseInt(EMPLOYEES[a][1]);
            String name = EMPLOYEES[a][2];
            int age = Integer.parseInt(EMPLOYEES[a][3]);
            int salary = Integer.parseInt(EMPLOYEES[a][4]);
            int bonus;
            int stock;


            int type = Integer.parseInt(EMPLOYEES[a][0]);
            switch (type) {
                case EMPLOYEE:
                    employees[a] = new Employee(id, name, age, salary);
                    break;
                case PROGRAMMER:
                    Equipment equipment = creatEquipment(a);
                    employees[a] = new Programmer(id, name, age, salary, equipment);
                    break;
                case DESIGNER:
                    Equipment equipment1 = creatEquipment(a);
                    bonus = Integer.parseInt(EMPLOYEES[a][4]);
                    employees[a] = new Designer(id, name, age, salary, equipment1, bonus);
                    break;
                case ARCHITECT:
                    Equipment equipment2 = creatEquipment(a);
                    bonus = Integer.parseInt(EMPLOYEES[a][4]);
                    stock = Integer.parseInt(EMPLOYEES[a][5]);
                    employees[a] = new Architect(id, name, age, salary, equipment2, bonus, stock);
                    break;

                default:
                    throw new IllegalStateException("Unexpected value: " + type);
            }
        }
    }

    /**
     * 获取制定位置员工的设备
     *
     * @return
     */
    public Equipment creatEquipment(int index) {
        int type = Integer.parseInt(EQUIPMENTS[index][0]);
        switch (type) {
            case PC:
                String model = EQUIPMENTS[index][1];
                String display = EQUIPMENTS[index][2];
                return new PC(model, display);

            case NOTEBOOK:
                String model1 = EQUIPMENTS[index][1];
                int price = Integer.parseInt(EQUIPMENTS[index][2]);
                return new NoteBook(model1, price);

            case PRINTER:
                String name = EQUIPMENTS[index][1];
                String type1 = EQUIPMENTS[index][2];
                return new Printer(name, type1);
        }
        return null;
    }

    public Employee[] getAllEquipment() {
        return employees;

    }

    public Employee getEmployee(int index) throws TeamException {
        for (int a = 0; a < employees.length; a++) {
            if (employees[a].getId() == index) { // 还记得-127 - 128 之间吗?
                return employees[a]; // 会运行到找到为止那么就结束不运行后面的代码
            }
        }
        throw new TeamException("找不到指定的员工");
    }
}