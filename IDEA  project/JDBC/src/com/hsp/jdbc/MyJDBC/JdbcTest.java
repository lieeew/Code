package com.hsp.jdbc.MyJDBC;

/**
 * @Auther: QiuXinYu
 * @Date: 2023/1/10 - 01 - 10
 * @Description: com.hsp.jdbc.MyJDBC
 */
public class JdbcTest {
    public static void main(String[] args) {
        JdbcInterface mysql = new MySqlJdbcImplement();
        mysql.getConnection();
        mysql.crud();
        mysql.close();

        JdbcInterface oracle = new OracleJdbcImplement();
        oracle.getConnection();
        oracle.crud();
        oracle.close();
    }
}
