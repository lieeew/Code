package com.hspedu.furns.service.impl;

import com.hspedu.furns.DAO.FurnDAO;
import com.hspedu.furns.DAO.Impl.FurnDAOImpl;
import com.hspedu.furns.entity.Furn;
import com.hspedu.furns.service.FurnService;

import java.util.ArrayList;

/**
 * @Author: qxy
 * @Date: 2023/5/5
 * @Description:
 */
public class FurnServiceImpl implements FurnService {
    private final FurnDAO furnDAO = new FurnDAOImpl();

    @Override
    public ArrayList<Furn> queryFurns() {
        return furnDAO.queryFurns();
    }

    @Override
    public boolean updateFurn(Furn furn) {
        return furnDAO.updateFurn(furn) > 0;
    }

    @Override
    public Furn getFurnById(Integer id) {
        return furnDAO.getFurnById(id);
    }
}
