package com.hspedu.furns.DAO.impl;

import com.hspedu.furns.DAO.BasicDAO;
import com.hspedu.furns.DAO.FurnDAO;
import com.hspedu.furns.entity.Furn;
import com.hspedu.furns.entity.Page;

import java.util.List;

/**
 * @Author: qxy
 * @Date: 2023/4/16
 * @Description:
 */
public class FurnDAOImpl extends BasicDAO<Furn> implements FurnDAO {

    /**
     * 返回查询的结果分页的信息
     *
     * @return 每一个的Furn类型的List
     */
    @Override
    public List<Furn> queryFurns() {
        // LIMIT 每页的数据量 * (第n页 - 1) , 每页的数据量
        return queryMulti("SELECT `id`, `name`, `maker`, `price`, `sales`, `stock`, `img_path` imgPath FROM furn ", Furn.class);
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
        // sql语句需要注意空格
        return update("UPDATE furn SET `name` = ?, `maker` = ?, `price` = ?, `sales` = ?, `stock` = ? ,`img_path` = ? WHERE id = ?",
                furn.getName(), furn.getMaker(), furn.getPrice(), furn.getSales(), furn.getStock(), furn.getImgPath(), furn.getId());
    }

    @Override
    public int getTotalRow() {
        // 这里不要直接 向下转型为Integer 会报错, 原因是他其实是long类型的
        return ((Number) queryScalar("SELECT COUNT(*) FROM furn")).intValue();
    }


    @Override
    public List<Furn> getItems(int begin, int pageSize) {
        String sql = "SELECT `id`, `name`, `maker`, `price`, `sales`, `stock`, `img_path` imgPath FROM furn LIMIT ? ,?";
        return queryMulti(sql, Furn.class, begin, pageSize);
    }

    @Override
    public int getTotalRowByName(String name) {
        String sql = "SELECT COUNT(*) FROM furn WHERE `name` LIKE ?";
        return ((Number) queryScalar(sql, "%" + name + "%")).intValue();
    }

    @Override
    public List<Furn> getPageItemsByName(String name, int begin, int pageSize) {
        String sql = "SELECT `id`, `name`, `maker`, `price`, `sales`, `stock`, `img_path` imgPath FROM furn WHERE name LIKE ? LIMIT ? ,?";
        return queryMulti(sql, Furn.class,"%" + name + "%", begin, pageSize);
    }
}
