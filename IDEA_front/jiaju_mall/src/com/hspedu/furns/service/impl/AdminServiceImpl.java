package com.hspedu.furns.service.impl;

import com.hspedu.furns.DAO.AdminDAO;
import com.hspedu.furns.DAO.impl.AdminDAOImpl;
import com.hspedu.furns.entity.Admin;
import com.hspedu.furns.service.AdminService;

/**
 * @Author: qxy
 * @Date: 2023/4/14
 * @Description:
 */
public class AdminServiceImpl implements AdminService {
    private AdminDAO adminDAO = new AdminDAOImpl();

    /**
     * 用户登录
     * @param admin admin对象
     */
    public Admin login(Admin admin) {
        return adminDAO.getAdminByUsername(admin.getName(), admin.getPassword());
    }

}
