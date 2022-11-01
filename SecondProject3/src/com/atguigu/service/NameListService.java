package com.atguigu.service;

import com.atguigu.domain.*;
import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;

import javax.print.DocFlavor;

import java.util.concurrent.TimeoutException;

import static com.atguigu.service.Data.EMPLOYEES;
import static com.atguigu.service.Data.*;


/**
 * @Auther: qiuxinyu
 * @Date: 2022/10/6 - 10 - 06
 * @Description: com.atguigu.service
 */
public class NameListService {

    private Employee[] employees;

    public NameListService() {
        employees = new Employee[EMPLOYEES.length];

        for (int a = 0; a < employees.length; a++) {
            // 共同属性
            int id = Integer.parseInt(EMPLOYEES[a][1]);
            String name = EMPLOYEES[a][2];
            int age = Integer.parseInt(EMPLOYEES[a][3]);
            int salary = Integer.parseInt(EMPLOYEES[a][4]);

            //  特有属性
            int bonus;
            int stock;
            Equipment eq;

            int type = Integer.parseInt(EMPLOYEES[a][0]);

            switch (type) {
                case EMPLOYEE:
                    employees[a] = new Employee(age, name, id, salary);
                    break;
                case PROGRAMMER:
                    eq = creatEquipment(a);
                    employees[a] = new Programmer(age, name, id, salary, eq);
                    break;
                case DESIGNER:
                    eq = creatEquipment(a);
                    bonus = Integer.parseInt(EMPLOYEES[a][5]);
                    employees[a] = new Designer(age, name, id, salary,eq, bonus);
                    break;
                case ARCHITECT:
                    eq = creatEquipment(a);
                    bonus = Integer.parseInt(EMPLOYEES[a][5]);
                    stock = Integer.parseInt(EMPLOYEES[a][6]);
                    employees[a] = new Architect(age, name, id, salary,eq, bonus, stock);
                    break;

            }
        }
    }

    public Equipment creatEquipment(int index) {

            String model;
            int price;
            String name;
            String display;
            String type;
            int typechoice = Integer.parseInt(EQUIPMENTS[index][0]);

            switch (typechoice) {
                case PC:
                    model = EQUIPMENTS[index][1];
                    display = EQUIPMENTS[index][2];
                    return new PC(model, display);
                case PRINTER:
                    name = EMPLOYEES[index][1];
                    type = EQUIPMENTS[index][2];
                    return new Printer(name, type);

                case NOTEBOOK:
                    model = EQUIPMENTS[index][1];
                    price = Integer.parseInt(EQUIPMENTS[index][2]);
                    return new NoteBook(model, price);

            }
            return null;
        }



    public Employee[] getAllEmploye() {
        return employees;
    }

    public Employee getEmployee(int index) throws TimeoutException {
        for (int a = 0; a < employees.length; a++) {
            if (employees[a].getId() == index) return employees[a];
        }
        throw new TimeoutException("未找到该用户");
    }


}
