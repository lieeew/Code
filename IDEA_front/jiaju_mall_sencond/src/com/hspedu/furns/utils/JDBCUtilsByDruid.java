package com.hspedu.furns.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author 韩顺平
 * @version 1.0
 * 基于druid数据库连接池的工具类
 */
public class JDBCUtilsByDruid {

    public static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    private static DataSource ds;

    //在静态代码块完成 ds初始化
    static {
        Properties properties = new Properties();
        try {
            properties.load(JDBCUtilsByDruid.class.getClassLoader().getResourceAsStream("druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //编写getConnection方法
//    public static Connection getConnection() throws SQLException {
//        return ds.getConnection();
//    }
    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        if (threadLocal.get() == null) {
            connection = ds.getConnection();
            threadLocal.set(connection);
        } else {
            connection = threadLocal.get();
        }
        connection.setAutoCommit(false);
        return connection;
    }


    //关闭连接, 老师再次强调： 在数据库连接池技术中，close 不是真的断掉连接
    //而是把使用的Connection对象放回连接池


    /**
     * 提交, 修改
     */
    public static void commit() {
        try {
            threadLocal.get().commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                threadLocal.get().close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        // 老师说明
        // 1. 当提交后, 把connection从ThreadLocal中移除出去
        // 2. 如果不移除的话 ThreadLocal 长期占有会影响效率
        // 3. 不移除 tomcat 底层不知道要出什么bug
        threadLocal.remove();
    }

    /**
     * 出现异常, 回滚
     */
    public static void rollBack() {
        try {
            threadLocal.get().rollback();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                threadLocal.get().close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            // 老师说明
            // 1. 当提交后, 把connection从ThreadLocal中移除出去
            // 2. 如果不移除的话 ThreadLocal 长期占有会影响效率
            // 3. 不移除 tomcat 底层不知道要出什么bug
            threadLocal.remove();
        }
    }

//    public static void close(ResultSet resultSet, Statement statement, Connection connection) {
//
//        try {
//            if (resultSet != null) {
//                resultSet.close();
//            }
//            if (statement != null) {
//                statement.close();
//            }
//            if (connection != null) {
//                connection.close();
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
