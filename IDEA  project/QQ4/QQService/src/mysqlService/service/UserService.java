package mysqlService.service;

import mysqlService.dao.UserDAO;
import qqcommen.User;

/**
 * @Author: qxy
 * @Date: 2023/1/29 13
 * @Description:
 */
public class UserService {
    private UserDAO userDAO = new UserDAO();

    /**
     * 判断登录信息是否正确
     */
    public boolean check(String userId, String psw) {
        User user = userDAO.querySingle("select * from user where userId = ? and psw = md5(?)", User.class, userId, psw);
        return user != null;
    }
}
