package qqcommen;

import java.io.Serializable;

/**
 * @Author: qxy
 * @Date: 2023/1/28 08
 * @Description:
 */
public class User implements Serializable {
    private static final long serialVersionUID = -5467710L;
    private String userId;
    private String psw;

    public User() {
    }

    public User(String userId, String psw) {
        this.userId = userId;
        this.psw = psw;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }
}
