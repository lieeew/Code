package com.hspedu.furns.test;

import com.hspedu.furns.utils.JDBCUtilsByDruid;
import org.junit.Test;

import java.sql.Connection;

/**
 * ClassName: JDBCTest
 * Package: com.hspedu.furns.test
 *
 * @Author: leikooo
 * @Creat: 2023/5/8 - 13:59
 * @Description:
 */
public class JDBCTest {

    @Test
    public void test() throws Exception {
        Connection connection = JDBCUtilsByDruid.getConnection();
        Connection connection1 = JDBCUtilsByDruid.getConnection();
        System.out.println("connection1 = " + connection1);
        System.out.println("connection = " + connection);

    }

    public static void main(String[] args) {

    }
}
