package com.hspedu.furns.DAO;

import com.hspedu.furns.entity.Admin;

/**
 * @Author: qxy
 * @Date: 2023/4/14
 * @Description:
 */
public interface AdminDAO {

    /**
     * 通过名字获取数据
     */
    Admin getAdminByUsername(String username, String password);

}
