package com.hspedu.furns.service.impl;

import com.hspedu.furns.DAO.FurnDAO;
import com.hspedu.furns.DAO.impl.FurnDAOImpl;
import com.hspedu.furns.entity.Furn;
import com.hspedu.furns.service.FurnService;

import java.util.List;

/**
 * @Author: qxy
 * @Date: 2023/4/16
 * @Description:
 */
public class FurnServiceImpl implements FurnService {
    private FurnDAO furnDAO = new FurnDAOImpl();

    @Override
    public List<Furn> list() {
        return furnDAO.queryFurns();
    }

    /**
     * 添加账单
     *
     * @return true 表示添加成功      false 表示添加失败
     */
    @Override
    public boolean add(Furn furn) {
        return furnDAO.add(furn) > 0;
    }

    @Override
    public boolean deleteFurnById(Furn furn) {
        return furnDAO.deleteFurnById(furn) > 0;
    }

    @Override
    public Furn getFurnById(Furn furn) {
        return furnDAO.getFurnById(furn.getId());
    }

    @Override
    public boolean updateFurnInfo(Furn furn) {
        return furnDAO.update(furn) > 0;
    }
}
