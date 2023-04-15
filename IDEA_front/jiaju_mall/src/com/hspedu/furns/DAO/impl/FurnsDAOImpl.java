package com.hspedu.furns.DAO.impl;

import com.hspedu.furns.DAO.BasicDAO;
import com.hspedu.furns.DAO.FurnsDAO;
import com.hspedu.furns.entity.Furns;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: qxy
 * @Date: 2023/4/15
 * @Description:
 */
public class FurnsDAOImpl extends BasicDAO<Furns> implements FurnsDAO{

    public List<Furns> getFurensValue() {
        return queryMulti("SELECT * FROM furns", Furns.class);
    }

    @Override
    public boolean deleteFurn(int id) {
        return update("DELETE FROM furns WHERE id = ?", id) > 0;
    }
}
