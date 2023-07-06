package com.yupi.user_center.common;

import lombok.Data;

/**
 * @author leikooo
 * @create 2023-07-06 19:51
 * @Package com.yupi.user_center.common
 * @Description 通用返回类
 */
@Data
public class BaseResponse<T> {
    /**
     * 业务代码
     */
    private int code;
    /**
     * 封装的数据
     */
    private T data;
    /**
     * 业务代码的描述
     */
    private String message;

    public BaseResponse(int code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public BaseResponse(int code, T data) {
        this(code, data, "");
    }
}
