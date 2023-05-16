package com.atguigu.team.service;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/28 - 09 - 28
 * @Description: com.atguigu.team.service
 */
public class TeamException extends Exception{

    static final long serialVersionUID = -3387513124229948L;

    public TeamException() {
    }

    public TeamException(String message) {
        super(message);
    }
}
