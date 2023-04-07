package com.hspedu.ajax.Service;

import com.hspedu.ajax.DAO.UserDAO;
import com.hspedu.ajax.entity.User;

/**
 * @Author: qxy
 * @Date: 2023/4/7
 * @Description: 提供业务方法
 */
public class UserService {
    private UserDAO userDao = new UserDAO();

    public User getUser(String uname) {
        return userDao.querySingle("select * from user where name = ?", User.class, uname);
    }
}
