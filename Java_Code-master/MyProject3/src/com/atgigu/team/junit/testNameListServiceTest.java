package com.atgigu.team.junit;

import com.atguigu.team.domain.Employee;
import com.atguigu.team.service.NameListService;
import com.atguigu.team.service.TeamException;
import org.junit.Test;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/29 - 09 - 29
 * @Description: com.atgigu.team.junit
 */

/**
 * 进行测试自己写过的代码, 这个比较重要
 *
 */
public class testNameListServiceTest {


    @Test
    public void testGetAllEquipment() {
        NameListService service = new NameListService();
        Employee[] employees = service.getAllEquipment();

        for (int a = 0; a < employees.length; a++) {
            System.out.println(employees[a].toString());
        }
    }

    @Test
    public void testGetemployee () throws TeamException {
        int id = 3;
        NameListService service = new NameListService();
        try {
            Employee employee = service.getEmployee(id);
            System.out.println(employee.toString());
        } catch (TeamException e) {
            throw new TeamException("未找到该用户啊");
        }
    }
}




