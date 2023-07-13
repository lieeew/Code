package com.leikooo.hspmybatis.config;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

/**
 * @author leikooo
 * @create 2023-07-13 16:30
 * @Package com.leikooo.hspmybatis.config
 * @Description 记录对应的 Mapper 的方法信息
 */
@Getter
@Setter
public class Function {
    /**
     * sql 类型， 比如 select、insert、update、delete
     */
    private String sqlType;
    /**
     * 方法名
     */
    private String funcName;
    /**
     * 需要执行的 sql
     */
    private String sql;

    /**
     * 返回值类型
     */
    private Object resultType;
    /**
     * 参数类型
     */
    private String parameterType;


}
