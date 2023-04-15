package com.hspedu.furns.service;

import com.hspedu.furns.entity.Furns;

import java.util.List;

/**
 * @Author: qxy
 * @Date: 2023/4/15
 * @Description:
 */
public interface FurnsService {

    List<Furns> getFurnInfor();

    boolean delete(Furns fs);
}
