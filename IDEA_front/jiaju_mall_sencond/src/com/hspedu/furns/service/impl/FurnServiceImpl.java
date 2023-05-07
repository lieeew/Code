package com.hspedu.furns.service.impl;

import com.hspedu.furns.DAO.FurnDAO;
import com.hspedu.furns.DAO.Impl.FurnDAOImpl;
import com.hspedu.furns.entity.Furn;
import com.hspedu.furns.entity.Page;
import com.hspedu.furns.service.FurnService;

import java.util.ArrayList;
import java.util.HashMap;

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

    /**
     * 分页
     *
     * @param pageSize 每一页的数量
     * @param pageNo   第几页
     */
    @Override
    public Page page(Integer pageSize, Integer pageNo) {
        Page page = new Page();
        page.setPageNo(pageNo); // 当前是第几页
        // 每一页家居的数量
        page.setPageSize(pageSize);
        //  所有家居的数量
        int pageItemSize = furnDAO.queryFurns().size();
        page.setTotalItemSize(pageItemSize);
        // 设置分页的总数
        int totalCount = 1;
        if (pageItemSize % pageSize == 0) {
            // 6 % 3 = 0  6 / 3 = 2
            totalCount = pageItemSize / pageSize;
        } else {
            totalCount = pageItemSize / pageSize + 1;
        }
        page.setTotalCount(totalCount);
        // 每一页家居的集合 需要 limit ?, ? 这两个属性
        ArrayList<Furn> furns = furnDAO.queryFurnForPage(pageSize * (pageNo - 1), pageSize);
        page.setFurns(furns);
        return page;
    }
}
