package com.hspedu.ajax.Test;

import com.hspedu.ajax.Service.UserService;
import com.hspedu.ajax.entity.User;

/**
 * @Author: qxy
 * @Date: 2023/4/7
 * @Description:
 */
public class A {
    public static void main(String[] args) {
        User king = new UserService().getUser("king");
        System.out.println("king = " + king);

    }
}
