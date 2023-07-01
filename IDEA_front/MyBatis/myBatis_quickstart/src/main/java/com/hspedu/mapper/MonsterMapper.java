package com.hspedu.mapper;

import com.hspedu.entity.Monster;

import java.util.List;

/**
 * @author leikooo
 * @create 2023-07-01 11:01
 * @Package com.hspedu.mapper
 * @Description 1. 这个一个接口
 * 2. 该接口用于什么操作 Monster 表的方法
 * 3. 这些方法可以通过注解或者 XML 文件来实现
 */
public interface MonsterMapper {
    /**
     * 添加 monster 对象
     */
    void addMonster(Monster monster);

    void deleteMonsterById(Integer id);

    /**
     * 修改 Monster
     */
    void updateMonster(Monster monster);

    /**
     * 查询-根据 id
     */
    Monster getMonsterById(Integer id);

    /**
     * 查询所有的 Monster
     */
    List<Monster> findAllMonster();
}
