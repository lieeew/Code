package DAO;

import UTILS.JDBCUtilsByDruid;
import jdk.nashorn.internal.objects.NativeUint8Array;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author: qxy
 * @Date: 2023/1/25 09
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
             JDBCUtilsByDruid.closeConnection(connection, null,null);
         }
         return update;
     }

    /**
     * 返回List<>
     */
    public List<T> queryMulti(String sql, Class<T> tClass, Object...parameters) {
        Connection connection = JDBCUtilsByDruid.getConnection();
        List<T> query = null;
        try {
            query = qr.query(connection, sql, new BeanListHandler<T>(tClass), parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.closeConnection(connection, null, null);
        }
        return query;
    }

    /**
     * 返回单条记录
     */
    public T querySingle(String sql, Class<T> tClass, Object...parameters) {
        Connection connection = JDBCUtilsByDruid.getConnection();
        T query = null;
        try {
            query = qr.query(connection, sql, new BeanHandler<T>(tClass), parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.closeConnection(connection, null, null);
        }
        return query;
    }

    /**
     * 返回单个属性值
     */
    public Object queryScala(String sql, Object...parameters) {
        Connection connection = JDBCUtilsByDruid.getConnection();
        Object query = null;
        try {
            query = qr.query(connection, sql, new ScalarHandler(), parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // 一定会执行
            JDBCUtilsByDruid.closeConnection(connection, null, null);
        }
        return query;
    }


}
