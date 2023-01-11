package com.hsp.jdbc;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

/**
 * @Auther: QiuXinYu
 * @Date: 2023/1/10 - 01 - 10
 * @Description: com.hsp.jdbc
 */
public class HomeWork01 {


    @Test
    public void test() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));

        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");

        Class.forName(driver);

        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        // String sql = "INSERT INTO news VALUES(1, '上海新闻'), (2, '北京新闻'), (3, '天津新闻'), (4, '杭州新闻'), (5, '南京新闻')";
//        String sql = "UPDATE news \n" +
//                "SET content = '一条新消息'\n" +
//                "WHERE id = 1";
        String sql = "DELETE FROM news\n" +
                "WHERE id = 3";
        int rows = statement.executeUpdate(sql);

        System.out.println(rows > 0 ? "成功" : "失败");

        statement.close();
        connection.close();
    }

}
