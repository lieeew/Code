package com.hspedu.Spring.Test;

import com.hspedu.Spring.bean.Monster;
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

        System.out.println("monster01 = " + monster01);
        System.out.println("monster02 = " + monster02 + ", monster02的name=" + monster02.getName());

        // 可以不用强转
        // 使用getBean()的其他重载方法
        Monster monster03 = ioc.getBean("monster01", Monster.class);
        System.out.println("monster03 = " + monster03);
    }

    @Test
    public void classPath() throws Exception {
        File file = new File(this.getClass().getResource("/").getPath());
        // E:\github\IDEA_%20project\Spring5\out\production\Spring5 这个是运行的类加载路径
        System.out.println(file);
    }

}
