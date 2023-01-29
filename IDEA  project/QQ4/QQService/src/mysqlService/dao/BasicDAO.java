package mysqlService.dao;

import mysqlService.utils.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author: qxy
 * @Date: 2023/1/28 08
 * @Description:
 */
public class BasicDAO<T> {
    private QueryRunner qr = new QueryRunner();

    /**
     * 执行dml语句
     */
    public int update(String sql, Object...parameters) {
        Connection connection = JDBCUtilsByDruid.getConnection();
        int update = 0;
        try {
            update = qr.update(connection, sql, parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.closeConnection(connection, null, null);
        }
        return update;
    }
    /**
     * 返回单行数据
     */
    public T querySingle(String sql, Class<T> tClass, Object...parameters) {
        Connection connection = JDBCUtilsByDruid.getConnection();
        T query = null;
        try {
            query = qr.query(connection, sql, new BeanHandler<>(tClass), parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.closeConnection(connection, null, null);
        }
        return query;
    }
}
