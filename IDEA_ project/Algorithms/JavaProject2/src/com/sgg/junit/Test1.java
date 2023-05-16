package com.sgg.junit;

import com.sgg.domain.Employee;
import com.sgg.serve.NameListService;
import com.sgg.serve.TeamException;
import org.junit.Test;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/1 - 11 - 01
 * @Description: com.sgg.junit
 */
public class Test1 {

    @Test
    public void NamelisTest() {
        NameListService nameListService = new NameListService();
        Employee[] allEmployee = nameListService.getAllEmployee();
        System.out.println("ID  姓名    年龄   工资    职位    状态      奖金       股票      领用设备\n");
        for (int i = 0; i < allEmployee.length; i++) {
            System.out.println(allEmployee[i].toString());
        }
    }

    @Test
    public void getEmployeeTest() {
        int index = 100;
        NameListService nameListService = new NameListService();
        try {
            Employee employee = nameListService.getEmployee(index);
            System.out.println(employee);
        } catch (TeamException e) {
            throw new RuntimeException(e);
        }
    }
}
