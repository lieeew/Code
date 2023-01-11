package com.hsp.jdbc;


import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @Auther: QiuXinYu
 * @Date: 2023/1/10 - 01 - 10
 * @Description: com.hsp.jdbc
 */
public class Jdbc01 {
    public static void main(String[] args) throws SQLException {
        // 1. 注册驱动
        Driver driver = new Driver();

        // 2. 得到链接
        // jdbc:mysql.properties:// 固定的协议, 通过jdbc的方式连接到mysql
        // localhost   主机, 可以是ip地址
        // 3306 某一个端口监听
        // jdbc  mysqlDbms的拿一个数据库
        // 本质就是一个socket连接
        String url = "jdbc:mysql.properties://localhost:3306/jdbc";
        // 将登录用户和密码放入到properties中
        Properties properties = new Properties();
        //setProperty的key是固定好的, 后面的可以随意更改
        properties.setProperty("user", "root"); // 用户
        properties.setProperty("password", "hsp"); // 密码
        Connection connect = driver.connect(url, properties);
        // 3. sql语句
        // String sql = "insert into actor values(null, '刘德华', '男', '1970-11-11', '110')";
//        String sql = "UPDATE actor \n" +
//                "SET name = '韩顺平'\n" +
//                "WHERE id = 1";
        String sql = "DELETE FROM actor\n" +
                "WHERE id = 1";
        // 得到一个Statement
        Statement statement = connect.createStatement();
        int rows = statement.executeUpdate(sql); // 如果是dml语句, 就是受影响的行数

        System.out.println(rows > 0 ? "成功" : "失败");

        // 4. 关闭链接
        // 如果不关闭, 那么其他的可能链接不上
        statement.close();
        connect.close();
    }
}
