package com.hspedu.furns.DAO.Impl;

import com.hspedu.furns.DAO.BasicDAO;
import com.hspedu.furns.DAO.FurnDAO;
import com.hspedu.furns.entity.Furn;

import java.util.ArrayList;

/**
 * @Author: qxy
 * @Date: 2023/5/5
 * @Description:
 */
public class FurnDAOImpl extends BasicDAO<Furn> implements FurnDAO {

    @Override
    public ArrayList<Furn> queryFurns() {
        String sql = "select `id`, `name`, `maker`, `price`, `sales`,`stock`, `img_path` AS `imgPath` from furn";
        return (ArrayList<Furn>) queryMulti(sql, Furn.class);
    }

    @Override
    public int updateFurn(Furn furn) {
        String sql = "update furn set `name` = ? , `maker` = ?, `price` = ?,  `sales` = ?, `stock` = ?, `img_path` = ? where id = ?";
        return update(sql, furn.getName(), furn.getMaker(), furn.getPrice(), furn.getSales(), furn.getStock(), furn.getImgPath(), furn.getId());
    }

    @Override
    public Furn getFurnById(Integer id) {
        String sql = "select `id`, `name`, `maker`, `price`, `sales`,`stock`, `img_path` AS `imgPath` from furn where id = ?";
        return querySingle(sql, Furn.class, id);
    }

    @Override
    public int deleteFurnById(Integer id) {
        String sql = "delete from furn where `id` = ?";
        return update(sql, id);
    }

    @Override
    public ArrayList<Furn> queryFurnForPage(Integer begin, Integer size) {
        String sql = "select `id`, `name`, `maker`, `price`, `sales`,`stock`, `img_path` AS `imgPath` from furn limit ?, ?";
        return (ArrayList<Furn>) queryMulti(sql, Furn.class, begin, size);
    }

    @Override
    public ArrayList<Furn> queryFurnForSearch(String word) {
        String sql = "select `id`, `name`, `maker`, `price`, `sales`, `price`, `stock`, `img_path` AS `imgPath` from furn where `name` LIKE ?";
        return (ArrayList<Furn>) queryMulti(sql, Furn.class, "%" + word + "%");
    }
}
