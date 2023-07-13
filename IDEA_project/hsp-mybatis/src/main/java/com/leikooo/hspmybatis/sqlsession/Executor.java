package com.leikooo.hspmybatis.sqlsession;

/**
 * @author leikooo
 * @create 2023-07-13 6:36
 * @Package com.leikooo.hspmybatis.sqlsession
 * @Description 执行器
 */
public interface Executor {
    /**
     * 执行 sql 语句
     * @param sql
     * @param parameter
     * @return
     * @param <T>
     */
    <T> T query(String sql, Object parameter);
}
