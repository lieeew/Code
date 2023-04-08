package com.hspEdu.Ajax.DAO;

import com.hspEdu.Ajax.utils.JDBCDruidFactory;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author: qxy
 * @Date: 2023/4/8
 * @Description:
 */
public class BasicDAO<T> {

    private QueryRunner qr = new QueryRunner();

    /**
     * 执行 dml语句
     */
    public boolean execute(String sql, Object... parameters) {
        Connection connection = JDBCDruidFactory.getConnection();
        try {
            // 执行dml语句都是使用update方法
            int update = qr.update(sql, parameters);
            return update > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCDruidFactory.closeConnection(connection, null, null);
        }
    }

    /**
     * 返回单个对象
     *
     * @param sql        sql语句
     * @param clazz      clazz对象
     * @param parameters 参数列表
     */
    public T querySingle(String sql, Class<T> clazz, Object... parameters) {
        Connection connection = JDBCDruidFactory.getConnection();
        try {
            return qr.query(connection, sql, new BeanHandler<T>(clazz), parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCDruidFactory.closeConnection(connection, null, null);
        }
    }

    /**
     * 返回单行多列数据
     */
    public List<T> queryList(String sql, Class<T> clazz, Object... parameters) {
        Connection connection = JDBCDruidFactory.getConnection();
        try {
            return qr.query(connection, sql, new BeanListHandler<T>(clazz), parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCDruidFactory.closeConnection(connection, null, null);
        }
    }

}
