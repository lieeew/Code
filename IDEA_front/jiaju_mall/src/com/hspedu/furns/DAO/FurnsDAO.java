package com.hspedu.furns.DAO;

import com.hspedu.furns.entity.Furns;

import java.util.List;

/**
 * @Author: qxy
 * @Date: 2023/4/15
 * @Description:
 */
public interface FurnsDAO {

    List<Furns> getFurensValue();

    boolean deleteFurn(int id);
}
