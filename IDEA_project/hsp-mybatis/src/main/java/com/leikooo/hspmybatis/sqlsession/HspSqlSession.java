package com.leikooo.hspmybatis.sqlsession;

import java.lang.reflect.Proxy;

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
    private HspConfiguration hspConfiguration = new HspConfiguration();
    /**
     * 执行器
     */
    private Executor executor = new HspExecutor();

    /**
     * 查询单个对象，简化版本
     *
     * @param statement sql 语句
     * @param parameter 参数
     * @param <T>
     * @return
     */
    public <T> T selectOne(String statement, Object parameter) {
        return (T) executor.query(statement, parameter);
    }

    /**
     * 返回代理 mapper 的动态对象
     *
     * @param clazz 这里传入的是 MonsterMapper.class
     * @return 返回的是接口的代理对象
     */
    public <T> T getMapper(Class<T> clazz) {
        System.out.println(clazz.getInterfaces());
        System.out.println(clazz.getInterfaces());
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz},
                new HspMapperProxy(this, hspConfiguration, clazz));
    }

}
