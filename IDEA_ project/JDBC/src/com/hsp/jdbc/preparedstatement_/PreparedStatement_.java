package com.hsp.jdbc.preparedstatement_;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

/**
 * @Auther: QiuXinYu
 * @Date: 2023/1/11 - 01 - 11
 * @Description: com.hsp.jdbc.preparedstatement_
 * 演示PrepareStatement如何使用
 */
public class PreparedStatement_ {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
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

        Connection connection = DriverManager.getConnection(url, user, password);
        String sql = "select * from admin where name = ? and pws = ?"; // 这个sql语句的?相当于占位符
        // 返回的是实现了PreparedStatement接口实现类的对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, admin_user);
        preparedStatement.setString(2, admin_psw);
        /*
            执行select 语句使用 executeQuery()
            执行dml语句使用executeUpdate()
         */
        // 这里不要在写sql写到参数里面
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }
        // 关闭资源
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
