package com.hsp.jdbc.preparedstatement_;

import javax.xml.transform.Source;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

/**
 * @Author: qxy
 * @Date: 2023/2/27
 * @Description:
 */
public class preparedStatement_SecondTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("请你输入账号 : ");
            String account = sc.next();
            System.out.print("请输入密码 : ");
            String pwd = sc.next();
            Properties properties = new Properties();
            properties.load(new FileInputStream("src\\mysql.properties"));
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            String url = properties.getProperty("url");
            String driver = properties.getProperty("driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            String sql = "select * from admin where name = ? and pws = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, account);
            preparedStatement.setString(2, pwd);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                System.out.println("登录成功!");
            } else {
                System.out.println("登录失败!");
            }

            // 关闭资源
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }



    }
}
