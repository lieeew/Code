package com.hspedu.furns.test;

import com.hspedu.furns.entity.Member;
import com.hspedu.furns.utils.JDBCUtilsByDruid;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author: qxy
 * @Date: 2023/4/12
 * @Description:
 */
public class JDBCTest {
    public static void main(String[] args) {
        try {
            Connection connection = JDBCUtilsByDruid.getConnection();
            // MemberDAO memberDAO = new MemberDAO();
            // Member king = memberDAO.querySingle("SELECT * FROM member WHERE username = ?", Member.class, "admin");
            // System.out.println("king = " + king);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
