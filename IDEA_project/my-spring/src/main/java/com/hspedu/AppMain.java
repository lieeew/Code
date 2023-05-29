package com.hspedu;

import com.hspedu.AOP.SmartAnimal;
import com.hspedu.Spring.UserAction;
import com.hspedu.Spring.UserDAO;
import com.hspedu.Spring.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 百花  二月
 */
public class AppMain {

    @Test
    public void test() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        UserAction userAction1 = ioc.getBean("userAction", UserAction.class);
        UserAction userAction2 = ioc.getBean("userAction", UserAction.class);

        System.out.println("userAction1 = " + userAction1);
        System.out.println("userAction2 = " + userAction2);

        UserDAO userDAO = ioc.getBean("userDAO", UserDAO.class);
        System.out.println("userDAO = " + userDAO);

        UserService userService = ioc.getBean("userService", UserService.class);
        System.out.println("userService = " + userService);


        userService.m1();

        SmartAnimal smartAnimal = ioc.getBean(SmartAnimal.class);
        smartAnimal.getSub(1, 2);
    }
}
