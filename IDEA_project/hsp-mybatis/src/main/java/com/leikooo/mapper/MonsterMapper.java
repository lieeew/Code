package com.leikooo.mapper;

import com.leikooo.entity.Monster;

/**
 * @author leikooo
 * @create 2023-07-13 15:19
 * @Package com.leikooo.mapper
 * @Description
 */
public interface MonsterMapper {
    /**
     * 查询方法
     * @param id 对应的 id
     * @return monster 对象
     */
    Monster getMonsterById(Integer id);

}
