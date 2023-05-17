package com.hsp.jdbc.statement_;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

/**
 * @Auther: QiuXinYu
 * @Date: 2023/1/11 - 01 - 11
 * @Description: com.hsp.jdbc.statement_
 */
public class Statement_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Scanner sc = new Scanner(System.in);
        /*
        这里必须使用nextLine(), 如果是next()的化输入空格或者 ' 就结束了
         */
        System.out.print("请输入账号 : ");
        String admin_user = sc.nextLine();
        System.out.print("请输入密码 : ");
        String admin_psw = sc.nextLine();


        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));

        String user = properties.getProperty("user");
        String url = properties.getProperty("url");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");

        // Class.forName(driver);

        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();

        String sql = "SELECT *\n" +
                "FROM admin\n" +
                "WHERE name ='" + admin_user + "' and pws = '" + admin_psw + "'";
        ResultSet resultSet = statement.executeQuery(sql);

        if (resultSet.next()) {
            System.out.println("登陆成功!");
        } else {
            System.out.println("登录失败!");
        }
        // 关闭资源
        resultSet.close();
        statement.close();
        connection.close();
    }
}
