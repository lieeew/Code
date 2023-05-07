package com.hspedu.furns.test;

import com.hspedu.furns.DAO.AdminDAO;
import com.hspedu.furns.DAO.Impl.AdminDAOImpl;
import com.hspedu.furns.entity.Admin;
import org.junit.Test;

/**
 * @Author: qxy
 * @Date: 2023/5/4
 * @Description:
 */
public class AdminDAOTest {
    private final AdminDAO adminDAO = new AdminDAOImpl();
    @Test
    public void testAdminDAO() {
        Admin admin = new Admin();
        admin.setPassword("admin");
        admin.setUsername("admin");
        Admin admin1 = adminDAO.verifyUsernameAndPwd(admin);
        System.out.println("admin1 = " + admin1);
    }

    public static void main(String[] args) {

    }
}
