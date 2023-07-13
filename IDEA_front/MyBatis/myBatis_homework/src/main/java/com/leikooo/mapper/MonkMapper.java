package com.leikooo.mapper;

import com.leikooo.entity.Monk;

/**
 * @author leikooo
 * @create 2023-07-11 21:13
 * @Package com.leikooo.mapper
 * @Description
 */
public interface MonkMapper {
    int addMonk(Monk monk);

    int updateMonk(Monk monk);

    int deleteMonk(int monkId);

    Monk getMonk(int monkId);

    Monk getAllMonk();

}
