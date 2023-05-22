package com.hspedu.Spring.Test;

import com.hspedu.Spring.bean.House;
import com.hspedu.Spring.bean.Monster;
import com.hspedu.Spring.component.MyComponent;
import com.hspedu.Spring.component.UserAction;
import com.hspedu.Spring.component.UserDAO;
import com.hspedu.Spring.component.UserService;
import com.hspedu.Spring.web.OrderAction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.management.monitor.Monitor;

/**
 * ClassName: SpringBeanXMLTest
 * Package: com.hspedu.Spring.Test
 *
 * @Author: leikooo
 * @Creat: 2023/5/21 - 11:32
 * @Description:
 */
public class SpringBeanXMLTest {

    @Test
    public void test1() throws Exception {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans06.xml");
        Object fac = ioc.getBean("factory02");
        System.out.println("beanFactory02 = " + fac);

    }

    @Test
    public void test2() throws Exception {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans06.xml");
        Object fac = ioc.getBean("mosnster02");
        System.out.println("beanFactory02 = " + fac);

    }

    @Test
    public void test3() throws Exception {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans06.xml");
        Object fac = ioc.getBean("emp");
        System.out.println("beanFactory02 = " + fac);

    }

    @Test
    public void test4() throws Exception {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans06.xml");
        Object fac = ioc.getBean("cat");
        Object fac1 = ioc.getBean("cat");
        Object fac2 = ioc.getBean("cat");
        Object fac3 = ioc.getBean("cat");
        System.out.println("beanFactory02 = " + fac);
    }

    @Test
    public void test5() throws Exception {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans06.xml");
        House house = ioc.getBean("house", House.class);
        System.out.println("house = " + house);

        ((ConfigurableApplicationContext) ioc).close();
    }

    @Test
    public void test6() throws Exception {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans06.xml");
        Monster house = ioc.getBean("monster", Monster.class);
        System.out.println("house = " + house);

        ((ConfigurableApplicationContext) ioc).close();
    }

    @Test
    public void test7() throws Exception {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans06.xml");
        OrderAction house = ioc.getBean("orderAction", OrderAction.class);
        System.out.println("house = " + house.getOrderService().getOrderDAO());

        ((ConfigurableApplicationContext) ioc).close();
    }

    /**
     * 通过注解配置bean
     * @throws Exception
     */
    @Test
    public void setBeanByAnnotation() throws Exception {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans07.xml");
        MyComponent myComponent = ioc.getBean("myComponent", MyComponent.class);
        UserService userService = ioc.getBean(UserService.class);
        UserDAO userDAO = ioc.getBean("user", UserDAO.class);
        UserAction userAction = ioc.getBean("userAction", UserAction.class);


        System.out.println("myComponent = " + myComponent);
        System.out.println("userDAO = " + userDAO);
        System.out.println("userService = " + userService);
        System.out.println("userAction = " + userAction);

        ((ConfigurableApplicationContext) ioc).close();
    }

}
