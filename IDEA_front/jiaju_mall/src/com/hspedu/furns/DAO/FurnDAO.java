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

    int update (Furn furn);
}
