package com.hsp.jdbc.MyJDBC;

/**
 * @Auther: QiuXinYu
 * @Date: 2023/1/10 - 01 - 10
 * @Description: com.hsp.jdbc.MyJDBC
 */
public class OracleJdbcImplement implements JdbcInterface{

    @Override
    public Object getConnection() {
        System.out.println("得到oracle的链接");
        return null;
    }

    @Override
    public void crud() {
        System.out.println("oracle实现crud");
    }

    @Override
    public void close() {
        System.out.println("关闭oracle链接");
    }
}
