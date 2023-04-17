package com.hspedu.furns.service;

import com.hspedu.furns.entity.Furn;

import java.util.List;

/**
 * @Author: qxy
 * @Date: 2023/4/16
 * @Description:
 */
public interface FurnService {

    List<Furn> list();

    boolean add(Furn furn);

    boolean remove(Furn furn);
}
