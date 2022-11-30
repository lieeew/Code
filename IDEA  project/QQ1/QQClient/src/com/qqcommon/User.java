package com.qqcommon;

import java.io.Serializable;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/26 - 11 - 26
 * @Description: com.hspedu.qqcommon
 * 表示一个用户/客户信息
 */
public class User implements Serializable {


    static final long serialVersionUID = 1L;

    private String userId; // 表示用户的id



    private String passWord; // 用户密码

    public User() {
    }

    public User(String userId, String passWord) {
        this.userId = userId;
        this.passWord = passWord;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
