package com.yupi.user_center.model.domain.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author leikooo
 * @create 2023-07-03 16:49
 * @Package com.yupi.user_center.model.domain.request
 * @Description 用户注册请求提
 */
@Data
public class UserRegisterRequest implements Serializable {
    private static final long serialVersionUID = -5663892868471135665L;
    private String userAccount;
    private String userPassword;
    private String checkPassword;
}
