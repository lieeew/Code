package common;

import java.io.Serializable;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/12/8 - 12 - 08
 * @Description: common
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String account;
    private String password;

    public User() {
    }


    public User(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
