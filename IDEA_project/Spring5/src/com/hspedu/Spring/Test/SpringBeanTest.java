package com.hspedu.Spring.Test;

import com.hspedu.Spring.Service.MemberServiceImpl;
import com.hspedu.Spring.bean.*;
import com.sun.org.apache.bcel.internal.util.ClassPath;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;

/**
 * ClassName: SpringBeanTest
 * Package: com.hspedu.Spring.Test
 *
 * @Author: leikooo
 * @Creat: 2023/5/16 - 10:46
 * @Description:
 */
public class SpringBeanTest {

    @Test
    public void testSpringBean() throws Exception {
        // 创建容器 ApplicationContext
        // 这个容器和一个配置文件关联
        // ioc是重量级的对象, 耗费的资源非常的多
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        // 通过getBean() 获取对应的对象
        // 默认返回的是Object, 但是运行类型是Monster
        Object monster01 = ioc.getBean("monster01");
        Monster monster02 = (Monster) ioc.getBean("monster01");
        //
        System.out.println("monster01 = " + monster01);
        System.out.println("monster02 = " + monster02 + ", monster02的name=" + monster02.getName());
        //
        // // 可以不用强转
        // // 使用getBean()的其他重载方法
        // Monster monster03 = ioc.getBean("monster01", Monster.class);
        // System.out.println("monster03 = " + monster03);
        //
        // // 查看容器注入了那些bean对象, 会输出bean的id
        // String[] beanDefinitionNames = ioc.getBeanDefinitionNames();
        // for (String beanDefinitionName : beanDefinitionNames) {
        //     System.out.println(beanDefinitionName);
        // }
    }

    @Test
    public void classPath() throws Exception {
        File file = new File(this.getClass().getResource("/").getPath());
        // E:\github\IDEA_project\Spring5\out\production\Spring5 这个是运行的类加载路径
        System.out.println(file);
    }

    @Test
    public void testSpring() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("cart_beans.xml");
        Cart cart = ioc.getBean("cart", Cart.class);
        System.out.println("cart = " + cart);
        System.out.println("cart.getPrice() = " + cart.getPrice());
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");

        Monster monster01 = ioc.getBean("com.hspedu.Spring.bean.Monster#0", Monster.class);
        System.out.println("monster01.getName() = " + monster01.getName());

        Monster monster02 = ioc.getBean("com.hspedu.Spring.bean.Monster#1", Monster.class);
        System.out.println("monster02.getMonsterId() = " + monster02.getMonsterId());
        System.out.println("hello 你好");
    }

    @Test
    public void test1() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        // 必须是单个对象
        Monster bean = ioc.getBean(Monster.class);
        System.out.println("bean = " + bean);
    }

    @Test
    public void setBeanByConstructor() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        Monster bean = ioc.getBean("monster03", Monster.class);
        System.out.println("bean = " + bean);

    }

    @Test
    public void setBeanByP() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        Monster monster = ioc.getBean("monster", Monster.class);
        System.out.println("monster = " + monster);
    }

    @Test
    public void testRef() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        MemberServiceImpl memberService = ioc.getBean("memberService", MemberServiceImpl.class);
        memberService.add();

    }

    /**
     * 通过内部类bean设置属性
     */
    @Test
    public void testRefByTwo() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        MemberServiceImpl memberService = ioc.getBean("memberService02", MemberServiceImpl.class);
        memberService.add();

    }

    /**
     * 通过String注入
     */
    @Test
    public void testRefByCollection() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        Master master = ioc.getBean("master", Master.class);
        Master master02 = ioc.getBean("master02", Master.class);
        System.out.println("master = " + master);
        System.out.println("master02 = " + master02);

    }

    /**
     * 使用util:list 名称空间赋值
     */
    @Test
    public void setBeanByUtils() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        BookStore bookStore = ioc.getBean("bookStore", BookStore.class);
        System.out.println("bookStore = " + bookStore);

    }

    /**
     * 给属性记性级联赋值
     */
    @Test
    public void setBeanByDept() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        Emo bookStore = ioc.getBean("emo", Emo.class);
        System.out.println("bookStore = " + bookStore);

    }

    /**
     * 通过静态工厂获取bean
     */
    @Test
    public void getBeanByStaticFactory() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");

        Monster bean = ioc.getBean("my_monster01", Monster.class);
        Monster bean2 = ioc.getBean("my_monster01", Monster.class);
        System.out.println("bean = " + bean);

        System.out.println(bean == bean2);
    }

    /**
     * 通过实例工厂获取bean
     */
    @Test
    public void getBeanByInstanceFactory() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");

        Monster bean = ioc.getBean("my_monster02", Monster.class);
        Monster bean2 = ioc.getBean("my_monster02", Monster.class);
        System.out.println("bean = " + bean);
        System.out.println("bean2 = " + bean2);
        System.out.println(bean == bean2);
    }

    @Test
    public void getBeanByBeanFactory() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        // 底层调用了 getObject() 方法
        Monster bean = ioc.getBean("myBeanFactory", Monster.class);
        System.out.println("bean = " + bean);
    }

    @Test
    public void setBeanByExtend() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        Monster bean = ioc.getBean("monster11", Monster.class);
        System.out.println("bean = " + bean);
    }
}
