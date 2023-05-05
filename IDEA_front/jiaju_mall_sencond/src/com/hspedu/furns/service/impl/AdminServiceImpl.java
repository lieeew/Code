package com.hspedu.furns.service.impl;

import com.hspedu.furns.DAO.AdminDAO;
import com.hspedu.furns.DAO.Impl.AdminDAOImpl;
import com.hspedu.furns.entity.Admin;
import com.hspedu.furns.service.AdminService;

/**
 * @Author: qxy
 * @Date: 2023/5/4
 * @Description:
 */
public class AdminServiceImpl implements AdminService {
    private AdminDAO adminDAO = new AdminDAOImpl();

    @Override
    public Admin login(Admin admin) {
        return adminDAO.verifyUsernameAndPwd(admin);
    }
}
