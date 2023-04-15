package com.hspedu.furns.test;

import com.hspedu.furns.DAO.FurnsDAO;
import com.hspedu.furns.DAO.impl.FurnsDAOImpl;
import com.hspedu.furns.entity.Furns;
import com.hspedu.furns.service.FurnsService;
import com.hspedu.furns.service.impl.FurnsServiceImpl;
import org.junit.Test;

import java.util.List;

/**
 * @Author: qxy
 * @Date: 2023/4/15
 * @Description:
 */
public class FurnsTest {

    @Test
    public void test1() throws Exception {
        FurnsDAO furnsDAO = new FurnsDAOImpl();
        List<Furns> furensValue = furnsDAO.getFurensValue();
        for (Furns furns : furensValue) {
            System.out.println(furns);
        }
        System.out.println();

    }

    @Test
    public void test2() throws Exception {
        FurnsService service = new FurnsServiceImpl();
        List<Furns> furnInfor = service.getFurnInfor();
        for (Furns furns : furnInfor) {
            System.out.println(furns);
        }

    }

    @Test
    public void test3() throws Exception {
        FurnsDAO furnsDAO = new FurnsDAOImpl();
        System.out.println(furnsDAO.deleteFurn(9));
    }

    @Test
    public void test4() throws Exception {
        FurnsService service = new FurnsServiceImpl();
        service.delete(new Furns(8, null, null, null, null, null, null));
    }
}
