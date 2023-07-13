package com.leikooo.hspmybatis.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author leikooo
 * @create 2023-07-13 16:36
 * @Package com.leikooo.hspmybatis.config
 * @Description 对 Mapper 信息进行封装
 */
@Getter
@Setter
public class MapperBean {
    /**
     * 接口全路径
     */
    private String interfaceName;
    /**
     * 接口下的所有方法
     */
    private List<Function> functions;
}
