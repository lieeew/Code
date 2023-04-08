package com.hspEdu.Ajax.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Author: qxy
 * @Date: 2023/4/8
 * @Description:
 */
public class JDBCDruidFactory {

    private static DataSource ds;

    static {
        System.out.println("静态代码块 ~~~");
        Properties properties = new Properties();
        try {
            // 这里报错了
            // JavaSE的目录和JavaWeb的目录不一样的
            // 这里可以使用绝对路径, 也可用使用
            // JavaWeb的路径中根本没有src目录
//            properties.load(new FileInputStream("E:\\github\\IDEA_front\\Ajax_\\src\\druid.properties"));
            properties.load(DruidDataSourceFactory.class.getClassLoader().getResourceAsStream("druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            // 下次就这样写, 报错了也知道
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeConnection(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
