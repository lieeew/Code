package com.hspedu.furns.service.impl;

import com.hspedu.furns.DAO.FurnDAO;
import com.hspedu.furns.DAO.impl.FurnDAOImpl;
import com.hspedu.furns.entity.Furn;
import com.hspedu.furns.entity.Page;
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

    @Override
    public Page<Furn> page(int pageNo, int pageSize) {
        // 创建一个page对象的数据, 填充属性
        Page<Furn> page = new Page<>();
        page.setPageSize(pageSize);
        page.setPageNo(pageNo);
        // 从数据库拿到数据
        int totalRow = furnDAO.getTotalRow();
        page.setTotalRow(totalRow);
        int pageTotalCount = totalRow / pageSize;
        if (pageTotalCount % 2 > 0) {
            pageTotalCount += 1;
        }
        page.setPageTotalCount(pageTotalCount);
        // LIMIT 每页的数据量 * (第n页 - 1) , 每页的数据量
        page.setItems(furnDAO.getItems(pageSize * (pageNo - 1), pageSize));
        return page;
    }

    @Override
    public Page<Furn> pageByName(String name, int pageNo, int pageSize) {
        Page<Furn> page = new Page<>();
        int totalRow = furnDAO.getTotalRowByName(name);
        int pageTotalCount = totalRow / pageSize;
        if (pageTotalCount % 2 > 0) {
            pageTotalCount += 1;
        }
        List<Furn> items = furnDAO.getPageItemsByName(name, pageSize * (pageNo - 1), pageSize);
        page.setPageSize(pageSize);
        page.setPageTotalCount(pageTotalCount);
        page.setTotalRow(totalRow);
        page.setItems(items);

        return page;
    }

}
