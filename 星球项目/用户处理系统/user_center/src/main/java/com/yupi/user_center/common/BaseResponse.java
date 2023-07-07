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

    /**
     * 具体描述
     */
    private String description;

    public BaseResponse(int code, T data, String message, String description) {
        this.code = code;
        this.data = data;
        this.message = message;
        this.description = description;
    }

    public BaseResponse(int code, T data) {
        this(code, data, "", "");
    }

    public BaseResponse(ErrorCode errorCode) {
        this(errorCode.getCode(), null, errorCode.getMessage(), errorCode.getDescription());
    }

    public BaseResponse(ErrorCode errorCode, String description) {
        this(errorCode.getCode(), null, errorCode.getMessage(), description);
    }

    public BaseResponse(ErrorCode errorCode,String message ,String description) {
        this(errorCode.getCode(), null, errorCode.getMessage(), description);
    }


}
