package com.qqcommon;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/26 - 11 - 26
 * @Description: com.hspedu.qqcommon
 */
public interface MessageType {
    String MESSAGE_LOGIN_SUCCEED = "1"; // 表示登录成功
    String MESSAGE_LOGIN_FAIL = "2"; // 表示登录失败
    String MESSAGE_COME_MES = "3"; // 普通消息包
    String MESSAGE_GET_ONLINE_FRIEND = "4"; // 要求返回在线用户列表
    String MESSAGE_RED_ONLINE_FRIEND = "5"; // 返回在线用户列表
    String MESSAGE_CLIENT_EXI = "6"; // 客户端请求退出

}
