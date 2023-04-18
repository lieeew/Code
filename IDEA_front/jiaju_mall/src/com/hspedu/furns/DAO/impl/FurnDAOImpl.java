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

    @Override
    public int deleteFurnById(Furn furn) {
        return update("DELETE FROM furn WHERE id = ?", furn.getId());
    }

    @Override
    public Furn getFurnById(int id) {
        return querySingle("select `id`, `name`, `maker`, `price`, `sales`, `stock`, `img_path` FROM furn where id = ?", Furn.class, id);
    }

    @Override
    public int update(Furn furn) {
        return update("UPDATE furn SET `name` = ?, `maker` = ?, `price` = ?, `sales` = ?, `stock` = ? ,`img_path` = ? WHERE id = ?",
                furn.getName(), furn.getMaker(), furn.getPrice(), furn.getSales(), furn.getStock(),furn.getImgPath(), furn.getId());
    }
}
