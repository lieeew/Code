package com.leikooo.hspmybatis.sqlsession;

/**
 * @author leikooo
 * @create 2023-07-13 7:33
 * @Package com.leikooo.hspmybatis.sqlsession
 * @Description
 */
public class HspSqlSession {
    /**
     * 配置信息
     */
    private HspConfiguration hspConfiguration;
    /**
     * 执行器
     */
    private Executor executor = new HspExecutor();

    /**
     * 查询单个对象，简化版本
     * @param statement
     * @param parameter
     * @return
     * @param <T>
     */
    public <T> T selectOne(String statement, Object parameter) {
        return (T) executor.query(statement, parameter);
    }

}
