
package com.atguigu.junit;

import com.atguigu.domain.Employee;
import com.atguigu.service.NameListService;
import org.junit.Test;

import javax.xml.soap.Name;
import java.util.concurrent.TimeoutException;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/10/6 - 10 - 06
 * @Description: com.atguigu.junit
 */
public class serviceTest {



    @Test
    public void NameListTest() {
        NameListService nameListService = new NameListService();
        Employee[] allEmploye = nameListService.getAllEmploye();
        for (int a = 0; a < allEmploye.length; a++) {
            System.out.println(allEmploye[a]);
        }
    }


    @Test
    public void getEmployeTest() throws TimeoutException {
        int id = 2;

        NameListService nameListService = new NameListService();
        Employee employee = nameListService.getEmployee(id);
        System.out.println(employee);
    }

}
