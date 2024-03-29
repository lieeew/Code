package com.hspedu.ajax.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Author: qxy
 * @Date: 2023/4/7
 * @Description:
 */
public class JDBCUtilsByDruid {
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
            properties.load(JDBCUtilsByDruid.class.getClassLoader().getResourceAsStream("druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            // 下次就这样写, 报错了也知道
            e.printStackTrace();
        }
    }

    /**
     * 得到连接
     */
    public static Connection getConnection() {
        try {
            System.out.println("getConnection() ~~~");
            return ds.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 关闭连接
     */
    public static void closeConnection(Connection connection, ResultSet result, PreparedStatement preparedStatement) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        if (result != null) {
            try {
                result.close();
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
    }
}
