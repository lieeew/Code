package com.hspedu.furns.DAO;

import com.hspedu.furns.entity.Admin;

/**
 * @Author: qxy
 * @Date: 2023/5/4
 * @Description:
 */
public interface AdminDAO {

    Admin verifyUsernameAndPwd(Admin admin);
}
