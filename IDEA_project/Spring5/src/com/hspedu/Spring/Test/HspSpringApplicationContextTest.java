package com.hspedu.Spring.Test;

import com.hspedu.Spring.Annotation.HspSpringApplicationContext;
import com.hspedu.Spring.Annotation.HspSpringConfigure;
import com.hspedu.Spring.Annotation2.HspSpringApplicationContext2;
import com.hspedu.Spring.Annotation2.HspSpringConfigure2;
import com.hspedu.Spring.Annotation3.HspSpringApplicationContext3;
import com.hspedu.Spring.Annotation3.HspSpringConfigure3;
import com.hspedu.Spring.component.MyComponent;
import com.hspedu.Spring.component.UserAction;
import com.hspedu.Spring.component.UserDAO;
import com.hspedu.Spring.component.UserService;
import com.hspedu.Spring.depinjection.PhoneService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: HspSpringApplicationContextTest
 * Package: com.hspedu.Spring.Test
 *
 * @Author: leikooo
 * @Creat: 2023/5/22 - 11:44
 * @Description:
 */
public class HspSpringApplicationContextTest {
    @Test
    public void test1() {
        HspSpringApplicationContext hspSpringApplicationContext = new HspSpringApplicationContext(HspSpringConfigure.class);

        UserDAO userDAO = hspSpringApplicationContext.getBean("user", UserDAO.class);
        UserAction userAction = hspSpringApplicationContext.getBean("action", UserAction.class);
        UserService userService = hspSpringApplicationContext.getBean("userService", UserService.class);
        MyComponent myComponent = hspSpringApplicationContext.getBean("myComponent", MyComponent.class);

        System.out.println("myComponent = " + myComponent);
        System.out.println("userService = " + userService);
        System.out.println("userAction = " + userAction);
        System.out.println("userDAO = " + userDAO);
    }

    @Test
    public void test2() {
        HspSpringApplicationContext2 hspSpringApplicationContext2 = new HspSpringApplicationContext2(HspSpringConfigure2.class);
        UserDAO bean = hspSpringApplicationContext2.getBean("user", UserDAO.class);
        System.out.println("bean = " + bean);

    }

    @Test
    public void test3() {
        HspSpringApplicationContext3 hspSpringApplicationContext3 = new HspSpringApplicationContext3(HspSpringConfigure3.class);

    }

    @Test
    public void setPropertyAutowired() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans08.xml");

        UserAction userAction = ioc.getBean("userAction", UserAction.class);
        userAction.sayOk();
        Object userService = ioc.getBean("userService200");
        System.out.println("userService = " + userService);
        System.out.println("userAction = " + userAction);
    }

    @Test
    public void setProByDependencyInjection() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans09.xml");
        PhoneService phoneService = ioc.getBean("phoneService", PhoneService.class);
        phoneService.save();

    }

}
