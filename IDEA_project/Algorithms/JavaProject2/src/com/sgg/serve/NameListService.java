package com.sgg.serve;

import com.sgg.domain.PC;
import com.sgg.domain.*;

import static com.sgg.view.Data.*;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/1 - 11 - 01
 * @Description: com.sgg.serve
 */
public class NameListService {
    private Employee[] employees = new Employee[EMPLOYEES.length];

    public NameListService() {

        for (int i = 0; i < EMPLOYEES.length; i++) {
            int choice = Integer.parseInt(EMPLOYEES[i][0]);

            int id = Integer.parseInt(EMPLOYEES[i][1]);
            String name = EMPLOYEES[i][2];
            int salary = Integer.parseInt(EMPLOYEES[i][4]);
            int age = Integer.parseInt(EMPLOYEES[i][3]);
            Equipment eq;
            switch (choice) {
                case EMPLOYEE:
                    employees[i] = new Employee(id,name, salary, age);
                    break;
                case PROGRAMMER:
                    eq = getEq(i);
                    employees[i] = new Programmer(id, name, salary, age, eq);
                    break;
                case DESIGNER:
                    eq = getEq(i);
                    int bounce = Integer.parseInt(EMPLOYEES[i][5]);
                    employees[i] = new Designer(id, name, salary, age, eq, bounce);
                    break;
                case ARCHITECT:
                    eq = getEq(i);
                    int bounces = Integer.parseInt(EMPLOYEES[i][5]);
                    int stock = Integer.parseInt(EMPLOYEES[i][6]);
                    employees[i] = new Architect(id, name, salary, age, eq, bounces, stock);
                    break;
            }
        }
    }

    private Equipment getEq(int index) {
        int type = Integer.parseInt(EQUIPMENTS[index][0]);
        Equipment eq;
        switch (type) {
            case PC:
                eq = new PC(EQUIPMENTS[index][1], EQUIPMENTS[index][2]);
                return eq;
            case NOTEBOOK:
                eq = new NoteBook(EQUIPMENTS[index][1], Integer.parseInt(EQUIPMENTS[index][2]));
                return eq;
            case PRINTER:
                eq = new Printer(EQUIPMENTS[index][1], EQUIPMENTS[index][2]);
                return eq;
        }
        return null;
    }

    public Employee[] getAllEmployee() {
        return employees;
    }

    public Employee getEmployee(int index) throws TeamException {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() == index) {
                return employees[i];
            }
        }
        throw new TeamException("未找到该用户");
    }

}
