package com.hspedu.furns.DAO.impl;

import com.hspedu.furns.DAO.AdminDAO;
import com.hspedu.furns.DAO.BasicDAO;
import com.hspedu.furns.entity.Admin;

/**
 * @Author: qxy
 * @Date: 2023/4/14
 * @Description:
 */
public class AdminDAOImpl extends BasicDAO<Admin> implements AdminDAO {


    @Override
    public Admin getAdminByUsername(String username, String password) {
        return querySingle("select * from admin where name = ? and password = MD5(?)", Admin.class, username, password);
    }

}
