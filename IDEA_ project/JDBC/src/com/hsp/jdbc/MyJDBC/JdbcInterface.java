package com.hsp.jdbc.MyJDBC;

/**
 * @Auther: QiuXinYu
 * @Date: 2023/1/10 - 01 - 10
 * @Description: com.hsp.jdbc.MyJDBC
 */
public interface JdbcInterface {
    // 链接
    public Object getConnection();

    // crud操作
    public void crud();

    // 关闭链接
    public void close();

}


