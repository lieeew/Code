package com.hspedu.furns.service;

import com.hspedu.furns.entity.Furn;
import com.hspedu.furns.entity.Page;

import java.util.List;

/**
 * @Author: qxy
 * @Date: 2023/4/16
 * @Description:
 */
public interface FurnService {

    List<Furn> list();

    boolean add(Furn furn);

    boolean deleteFurnById(Furn furn);

    Furn getFurnById(Furn furn);

    boolean updateFurnInfo(Furn furn);

    /**
     * 根据传入的begin和pageSize 返回对应的page对象
     * @param pageNo
     * @param pageSize
     * @return
     */
    Page<Furn> page(int pageNo, int pageSize);
}
