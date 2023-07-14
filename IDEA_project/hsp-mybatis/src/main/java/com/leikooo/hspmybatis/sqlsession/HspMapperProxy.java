package com.leikooo.hspmybatis.sqlsession;

import com.leikooo.hspmybatis.config.Function;
import com.leikooo.hspmybatis.config.MapperBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @author leikooo
 * @create 2023-07-13 21:05
 * @Package com.leikooo.hspmybatis.sqlsession
 * @Description 动态生成 Mapper 代理对象， 调用 HspExecutor
 */
public class HspMapperProxy implements InvocationHandler {
    /**
     * 配置文件
     */
    private HspConfiguration hspConfiguration;
    /**
     * 运行类，执行 sql
     */
    private HspSqlSession hspSqlSession;
    /**
     * 对应的 mapper 文件的名称
     */
    private String mapperFile;

    /**
     * 构造方法
     * @param hspSqlSession
     * @param hspConfiguration
     * @param clazz 这里 Class 文件比较容易获取到所以才使用传入 class 文件
     */
    public HspMapperProxy(HspSqlSession hspSqlSession, HspConfiguration hspConfiguration, Class clazz) {
        this.hspConfiguration = hspConfiguration;
        this.hspSqlSession = hspSqlSession;
        this.mapperFile = clazz.getSimpleName() + ".xml";
    }

    /**
     * 反射方法
     * @return
     * @throws Throwable
     */

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MapperBean mapperBean = hspConfiguration.readMapper("MonsterMapper.xml");
        if (!method.getDeclaringClass().getName().equals(mapperBean.getInterfaceName())) {
            // 不是和 MonsterMapper.xml 对应的文件
            return null;
        }

        List<Function> functions = mapperBean.getFunctions();
        if (functions == null || functions.size() == 0) {
            // 如果没有配置相关的参数
            return null;
        }

        for (Function function : functions) {
            if ("select".equals(function.getSqlType())) {
                if (method.getName().equals(function.getFuncName())) {
                    // 如果要执行的是 select ，就执行对应的 selectOne()
                    // 实际上 HspSqlSession 应该对应很多方法
                    // 根据不同的情况调用不同的方法，这里做了简化
                    return hspSqlSession.selectOne(function.getSql(), args[0]);
                }
            }
        }
        return null;
    }
}
