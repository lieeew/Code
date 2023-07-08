package com.yupi.user_center.common;

/**
 * @author leikooo
 * @create 2023-07-06 20:15
 * @Package com.yupi.user_center.common
 * @Description 全局错误码
 */
public enum ErrorCode {
    /**
     * 请求参数错误
     */
    PARAMS_ERROR(400, "请求参数错误", ""),
    /**
     * 请求数据为空
     */
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
    SUCCESS(0, "ok", ""),
    /**
     * 注册账号失败
     */
    SAVE_FAILURE(50001, "注册账号失败", "插入数据库失败"),
    /**
     * 系统内部异常
     */
    SYSTEM_ERROR(50002, "系统内部异常", "");
    /**
     * 状态码
     */
    private final int code ;
    /**
     * 状态码信息
     */
    private final String message;
    /**
     * 详细描述
     */
    private final String description;

    ErrorCode(int code, String message, String description) {
        this.code = code;
        this.message = message;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }
}
