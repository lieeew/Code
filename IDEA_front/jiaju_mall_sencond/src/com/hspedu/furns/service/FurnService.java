package com.hspedu.furns.service;

import com.hspedu.furns.entity.Furn;
import com.hspedu.furns.entity.Page;

import java.util.ArrayList;

/**
 * @Author: qxy
 * @Date: 2023/5/5
 * @Description:
 */
public interface FurnService {

    ArrayList<Furn> queryFurns();

    boolean updateFurn(Furn furn);
    Furn getFurnById(Integer id);
    Page page(Integer pageSize, Integer pageNo);
    ArrayList<Furn> searchFurn(String word);
}
