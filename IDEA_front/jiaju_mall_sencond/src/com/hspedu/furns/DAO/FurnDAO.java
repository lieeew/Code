package com.hspedu.furns.DAO;

import com.hspedu.furns.entity.Furn;

import java.util.ArrayList;

/**
 * @Author: qxy
 * @Date: 2023/5/5
 * @Description:
 */
public interface FurnDAO {


    ArrayList<Furn> queryFurns();
    int updateFurn(Furn furn);
    Furn getFurnById(Integer id);
    int deleteFurnById(Integer id);
    ArrayList<Furn> queryFurnForPage(Integer begin, Integer size);

}
