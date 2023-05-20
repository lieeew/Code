package com.hspedu.Spring.Test;

import com.hspedu.Spring.Service.MemberServiceImpl;
import com.hspedu.Spring.bean.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: SpringBean_secondTest
 * Package: com.hspedu.Spring.Test
 *
 * @Author: leikooo
 * @Creat: 2023/5/19 - 9:05
 * @Description:
 */
public class SpringBean_secondTest {

    @Test
    public void getBeanByClass() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans_second.xml");

        Monster bean = ioc.getBean(Monster.class);
        System.out.println("bean = " + bean);

    }

    @Test
    public void setBeanByConstructor() {

        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans_second.xml");

        Monster bean = ioc.getBean("monster03", Monster.class);
        System.out.println("bean = " + bean);
    }

    @Test
    public void setBeanByRef() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans_second.xml");

        MemberServiceImpl memberService = ioc.getBean("service", MemberServiceImpl.class);
        memberService.add();

    }

    @Test
    public void setBeanByArray() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans_second.xml");

        Master master = ioc.getBean("master", Master.class);
        System.out.println("master = " + master);

    }

    @Test
    public void setBeanBy( ) {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans_second.xml");
        BookStore bookStore = ioc.getBean("bookStore", BookStore.class);
        System.out.println("bookStore = " + bookStore);
    }

    @Test
    public void setBeanByInner() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans_second.xml");

        Emo emo = ioc.getBean("emo", Emo.class);
        System.out.println("emo = " + emo);
    }

    @Test
    public void getBeanByStaticFactory() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans_second.xml");
        Monster bean = ioc.getBean("staticFactory", Monster.class);
        System.out.println("bean = " + bean);
    }

    @Test
    public void getBeanByInstanceFactory() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans_second.xml");
        Monster bean = ioc.getBean("instanceFactory", Monster.class);
        System.out.println("bean = " + bean);

    }

    @Test
    public void getBeanByFactory() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        Monster bean = ioc.getBean("myBeanFactory", Monster.class);
        System.out.println("bean = " + bean);
    }

    @Test
    public void getBeanByScope() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        Cat cat = ioc.getBean("cat", Cat.class);
        Cat cat1 = ioc.getBean("cat", Cat.class);
        Cat cat2 = ioc.getBean("cat", Cat.class);
        System.out.println("cat = " + cat);

    }

}
