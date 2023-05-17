package com.hsp.jdbc.resultset_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @Auther: QiuXinYu
 * @Date: 2023/1/10 - 01 - 10
 * @Description: com.hsp.jdbc.resultset_
 * 演示Select 语句 ResultSet结果集合
 */
public class ResultSet_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));

        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");
        // 1. 注册驱动
        Class.forName(driver);
        // 2. 获取连接
        Connection connection = DriverManager.getConnection(url, user, password);
        // 3. 得到statement
        Statement statement = connection.createStatement();
        // 4. sql语句
        String sql = "select id, name, sex, borndate from actor";
        // 执行指定的sql语句, 获取到结果集
        ResultSet resultSet = statement.executeQuery(sql);
        // 使用while()循环去除结果集
        /*
        +----+-----------+-----+---------------------+-------+
        | id | name      | sex | borndate            | phone |
        +----+-----------+-----+---------------------+-------+
        |  1 | 刘德华    | 男  | 1990-12-12 00:00:00 | 112   |
        |  2 | jack      | 女  | 1998-11-11 00:00:00 | 110   |
        +----+-----------+-----+---------------------+-------+
         */
        while (resultSet.next()) { //next(), 把光标先后移动, 并判断下面有没有数据
            int id = resultSet.getInt(1); // 獲取這一行的第一列
            String name = resultSet.getString(2); // 獲取這一行的第二列
            String sex = resultSet.getString(3); // 獲取這一行的第三列
            Date date = resultSet.getDate(4);
            System.out.println(id + "\t" + name + "\t" + sex + "\t" + date);
        }
        // 取出结果集
        resultSet.close();
        statement.close();
        connection.close();
    }
}
