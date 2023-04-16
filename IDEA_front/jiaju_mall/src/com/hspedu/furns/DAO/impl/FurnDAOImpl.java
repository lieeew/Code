package com.hspedu.furns.DAO.impl;

import com.hspedu.furns.DAO.BasicDAO;
import com.hspedu.furns.DAO.FurnDAO;
import com.hspedu.furns.entity.Furn;

import java.util.List;

/**
 * @Author: qxy
 * @Date: 2023/4/16
 * @Description:
 */
public class FurnDAOImpl extends BasicDAO<Furn> implements FurnDAO {

    @Override
    public List<Furn> queryFurns() {
        return queryMulti("SELECT `id`, `name`, `maker`, `price`, `sales`, `stock`, `img_path` imgPath FROM furn", Furn.class);
    }

    @Override
    public Integer add(Furn furn) {
        return update("INSERT INTO furn (name, maker, price, sales, stock, img_path) VALUES (?, ?, ?, ?, ?, ?)",
                furn.getName(), furn.getMaker(), furn.getPrice(), furn.getSales(), furn.getStock(), furn.getImgPath());
    }
}
