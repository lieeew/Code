package com.hsp.jdbc;

import com.mysql.jdbc.Driver;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Auther: QiuXinYu
 * @Date: 2023/1/10 - 01 - 10
 * @Description: com.hsp.jdbc
 */
public class JdbcConnect {


    // 方式一, 静态加载
    @Test
    public void method1() throws SQLException {
        Driver driver = new Driver();
        String url = "jdbc:mysql.properties://localhost:3306/jdbc";
        // 将登录用户和密码放入到properties中
        Properties properties = new Properties();
        //setProperty的key是固定好的, 后面的可以随意更改
        properties.setProperty("user", "root"); // 用户
        properties.setProperty("password", "hsp"); // 密码
        Connection connect = driver.connect(url, properties);
        System.out.println(connect);
    }

    // 方式二, 利用反射
    @Test
    public void method2() throws Exception {
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();
        String url = "jdbc:mysql.properties://localhost:3306/jdbc";
        Properties properties = new Properties();
        //setProperty的key是固定好的, 后面的可以随意更改
        properties.setProperty("user", "root"); // 用户
        properties.setProperty("password", "hsp"); // 密码
        Connection connect = driver.connect(url, properties);
        System.out.println(connect);

    }

    // 方式三 利用DriverManager
    @Test
    public void method3() throws Exception {
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();

        // 创建一个url 和 user 和 password
        String url = "jdbc:mysql.properties://localhost:3306/jdbc";
        String user = "root";
        String password = "hsp";
        // 使用DriverManager的静态方法
        Connection connection = DriverManager.getConnection(url, user, password);// 注册Driver驱动
        System.out.println(connection);

    }

    // 利用Class.forName, 底层自动加载驱动
    // 老韩推荐使用, 用的比较多
    @Test
    public void method4() throws Exception {
        // Class.forName("com.mysql.properties.jdbc.Driver");
        // 这里不显示调用forName, 也不会有问题
        /*
        底层有一个静态代码块
        1. 静态代码块在类价值啊时回执行一次
        2. DriverManager.registerDriver(new Driver());
        3. 因此注册Driver的工作就完成了
        static {
            DriverManager.registerDriver(new Driver());
        }
         */
        String url = "jdbc:mysql.properties://localhost:3306/jdbc";
        String user = "root";
        String password = "hsp";
        // 使用DriverManager的静态方法
        Connection connection = DriverManager.getConnection(url, user, password);// 注册Driver驱动
        System.out.println(connection);
    }


    @Test
    public void method5() throws IOException, ClassNotFoundException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");

        // 利用反射
        Class.forName(driver);

        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);

    }
}
