package com.hspedu.Spring;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * ClassName: UserService
 * Package: com.hspedu.Spring
 *
 * @Author: leikooo
 * @Creat: 2023/5/28 - 12:45
 * @Description:
 */
@Component
public class UserService {
    // 该说不说, 该想想底层怎么实现的吧
    @Resource
    private UserDAO userDAO;


    public void m1() {
        userDAO.hi();
    }

    @PostConstruct // 使用注解指定init()方法 是初始化方法
    public void init() {
        System.out.println("UserService-init()~");
    }
}
