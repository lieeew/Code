package com.yupi.user_center.model.domain.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author leikooo
 * @create 2023-07-03 17:01
 * @Package com.yupi.user_center.model.domain.request
 * @Description
 */
@Data
public class UserLoginRequest implements Serializable {
    private static final long serialVersionUID = -3401357311924778926L;
    private String userAccount;
    private String userPassword;

}
