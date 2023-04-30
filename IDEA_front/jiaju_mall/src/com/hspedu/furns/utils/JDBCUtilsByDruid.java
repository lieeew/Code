package com.hspedu.furns.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author 韩顺平
 * @version 1.0
 * 基于druid数据库连接池的工具类
 */
public class JDBCUtilsByDruid {

    private static DataSource ds;
    private static ThreadLocal<Connection> threadLocalConn = new ThreadLocal<>();

    //在静态代码块完成 ds初始化
    static {
        Properties properties = new Properties();
        try {
            // web项目在out下面
            // properties.load(new FileInputStream("src\\druid.properties"));
            properties.load(JDBCUtilsByDruid.class.getClassLoader().getResourceAsStream("druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //编写getConnection方法
    // public static Connection getConnection() throws SQLException {
    //     return ds.getConnection();
    // }

    /**
     * 获取连接
     */
    public static Connection getConnection() {
        Connection connection = threadLocalConn.get();
        if (connection == null) { // 如果connection里面没有
            try {
                connection = ds.getConnection();
                // 将自动提交设置为false
                connection.setAutoCommit(false);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            threadLocalConn.set(connection);
        }
        return connection;
    }

    /**
     * 提交事务
     * 知识点 : mysql线程 + Java基础 + 线程 + 过滤机制 + ThreadLocal
     */
    public static void commit() {
        Connection connection = threadLocalConn.get();
        if (connection != null) {
            try {
                connection.commit();
            } catch (SQLException e) {
               e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        // 老师说明
        // 1. 当提交后, 把connection从ThreadLocal中移除出去
        // 2. 如果不移除的话 ThreadLocal 长期占有会影响效率
        // 3. 不移除 tomcat 底层不知道要出什么bug
        threadLocalConn.remove();
    }

    /**
     * 实现回滚操作
     */
    public static void rollBack() {
        Connection connection = threadLocalConn.get();
        if (connection != null) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        // 一定要处理
        threadLocalConn.remove();
    }


    //关闭连接, 老师再次强调： 在数据库连接池技术中，close 不是真的断掉连接
    //而是把使用的Connection对象放回连接池
    public static void close(ResultSet resultSet, Statement statement, Connection connection) {

        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
