package com.hspedu.furns.test;

import com.hspedu.furns.DAO.FurnDAO;
import com.hspedu.furns.DAO.impl.FurnDAOImpl;
import com.hspedu.furns.entity.Furn;
import com.hspedu.furns.service.FurnService;
import com.hspedu.furns.service.impl.FurnServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: qxy
 * @Date: 2023/4/16
 * @Description:
 */
public class FurnTest {
    private FurnDAO furnDAO = new FurnDAOImpl();
    private FurnService service = new FurnServiceImpl();

    @Test
    public void test() throws Exception {
        List<Furn> furns = furnDAO.queryFurns();
        for (Furn furn : furns) {
            System.out.println(furn);
        }
    }

    @Test
    public void test1() throws Exception {
        FurnService service = new FurnServiceImpl();
        List<Furn> furns = service.list();
        for (Furn furn : furns) {
            System.out.println("furn = " + furn);
        }
    }

    @Test
    public void test2() throws Exception {
        // ('Chair', 'ABC Furniture', 99.99, 100, 50, '/img/chair.jpg')
        Furn furn = new Furn(null, "Chair", "ABC Furniture", new BigDecimal("123.45"), 100, 50, "/img/chair.jpg");
        Integer add = furnDAO.add(furn);
        System.out.println("add = " + add);
    }

    @Test
    public void test3() throws Exception {
        Furn furn = new Furn(null, "Chair", "ABC Furniture", new BigDecimal("123.45"), 100, 50, "/img/chair.jpg");
        if (service.add(furn)) {
            System.out.println("SUCCESS");
        } else {
            System.out.println("FAILURE");
        }
    }
}
