package com.hspedu.furns.DAO;

import com.hspedu.furns.entity.Furn;

import java.util.List;

/**
 * @Author: qxy
 * @Date: 2023/4/16
 * @Description:
 */
public interface FurnDAO {

    List<Furn> queryFurns();

    Integer add(Furn furn);

    int deleteFurnById(Furn furn);

    Furn getFurnById(int id);

    /**
     * 将传入的furn对象, 更新到数据库
     */
    int update (Furn furn);

    /*
        在Page中有数据可以直接在DB中获取, 那么就直接在DAO层获取(通过写方法的形式)
     */

    /**
     * totalRow 获取totalRow中的数据
     */
    int getTotalRow();

    /**
     * 获取某一个页面的数据
     * @param begin 表示从那一条记录开始获取, 从0开始
     * @param pageSize 表示每一个页面的数据
     */
    List<Furn> getItems(int begin, int pageSize);


    /**
     * 通过名字获取分页的总页数
     */
    int getTotalRowByName(String name);

    /**
     * 通过名字获取page的items属性
     */
    List<Furn> getPageItemsByName(String name, int begin, int pageSize);

}
