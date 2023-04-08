package com.hspEdu.Ajax.service;

import com.hspEdu.Ajax.DAO.UserDAO;
import com.hspEdu.Ajax.entity.User;

/**
 * @Author: qxy
 * @Date: 2023/4/8
 * @Description:
 */
public class UserService {
    private UserDAO userDAO = new UserDAO();

    public User getUserByName(String name) {
        return userDAO.querySingle("SELECT * FROM user WHERE name = ?", User.class, name);
    }

}
