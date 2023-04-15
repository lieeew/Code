package com.hspedu.furns.service.impl;

import com.hspedu.furns.DAO.FurnsDAO;
import com.hspedu.furns.DAO.impl.FurnsDAOImpl;
import com.hspedu.furns.entity.Furns;
import com.hspedu.furns.service.FurnsService;

import java.util.List;

/**
 * @Author: qxy
 * @Date: 2023/4/15
 * @Description:
 */
public class FurnsServiceImpl implements FurnsService {
    private FurnsDAO furnsDAO = new FurnsDAOImpl();

    @Override
    public List<Furns> getFurnInfor() {
        return furnsDAO.getFurensValue();
    }

    @Override
    public boolean delete(Furns fs) {
        if (fs != null) {
            return furnsDAO.deleteFurn(fs.getId());
        } else {
            return false;
        }
    }
}
