package com.hspedu.furns.test;

import com.hspedu.furns.DAO.AdminDAO;
import com.hspedu.furns.DAO.impl.AdminDAOImpl;
import com.hspedu.furns.entity.Admin;
import com.hspedu.furns.service.AdminService;
import com.hspedu.furns.service.impl.AdminServiceImpl;
import org.junit.Test;

/**
 * @Author: qxy
 * @Date: 2023/4/14
 * @Description:
 */
public class AdminDAOTest {

    @Test
    public void test1() {
        AdminDAO adminDAO = new AdminDAOImpl();
        Admin admin = adminDAO.getAdminByUsername("admin", "admin");
        System.out.println("admin = " + admin);

    }


    @Test
    public void test2() {
        AdminService adminService = new AdminServiceImpl();
        Admin login = adminService.login(new Admin(null, "admin", "admin"));
        System.out.println("login = " + login);
    }
}
