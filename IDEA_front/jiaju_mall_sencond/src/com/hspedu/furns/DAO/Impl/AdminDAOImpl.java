package com.hspedu.furns.DAO.Impl;

import com.hspedu.furns.DAO.AdminDAO;
import com.hspedu.furns.DAO.BasicDAO;
import com.hspedu.furns.entity.Admin;

/**
 * @Author: qxy
 * @Date: 2023/5/4
 * @Description:
 */
public class AdminDAOImpl extends BasicDAO<Admin> implements AdminDAO {

    @Override
    public Admin verifyUsernameAndPwd(Admin admin) {
        String sql = "select `id`, `username`, `password` from admin where username = ? and password = md5(?)";
        return querySingle(sql, Admin.class, admin.getUsername(), admin.getPassword());
    }
}
