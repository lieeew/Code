package com.yupi.user_center.common;

/**
 * @author leikooo
 * @create 2023-07-06 20:15
 * @Package com.yupi.user_center.common
 * @Description 全局错误码
 */
public enum ErrorCode {

    PARAMS_ERROR(400, "请求参数错误", ""),

    PARAMS_NULL(4001, "请求数据为空", ""),
    /**
     * 无权限
     */
    NO_AUTH(40100, "无权限", ""),
    /**
     * 未登录
     */
    NOT_LOGIN(40101, "未登录", ""),
    /**
     * 登录成功
     */
    SUCCESS(0, "ok", "");

    private final int code ;

    private final String message;

    private final String desc;

    ErrorCode(int code, String message, String desc) {
        this.code = code;
        this.message = message;
        this.desc = desc;
    }
}
