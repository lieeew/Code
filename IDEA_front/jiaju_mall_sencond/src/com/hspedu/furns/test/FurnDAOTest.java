package com.hspedu.furns.test;

import com.hspedu.furns.DAO.FurnDAO;
import com.hspedu.furns.DAO.Impl.FurnDAOImpl;
import com.hspedu.furns.entity.Furn;
import org.junit.Test;

import javax.management.Query;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * @Author: qxy
 * @Date: 2023/5/5
 * @Description:
 */
public class FurnDAOTest {
    private final FurnDAO furnDAO = new FurnDAOImpl();
    @Test
    public void TestQueryFurns() {
        ArrayList<Furn> furns = furnDAO.queryFurns();
        System.out.println("furns = " + furns);
    }

    @Test
    public void TestUpdateFurn() {
        // furnDAO.updateFurn(new Furn(1, "hsp", "hspEdu", new BigDecimal("0"), 0, 0, "hsp"));
        Furn furnById = furnDAO.getFurnById(2);
        System.out.println(furnById);
    }

    @Test
    public void testDeleteFurn() {
        // int i = furnDAO.deleteFurnById(2);
        // System.out.println("i = " + i);

        // ArrayList<Furn> furns = furnDAO.queryFurnForPage(0, 3);
        // System.out.println("furns = " + furns);

    }
}
