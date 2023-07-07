package com.yupi.user_center.exception;

import com.yupi.user_center.common.ErrorCode;

/**
 * @author leikooo
 * @create 2023-07-07 7:46
 * @Package com.yupi.user_center.exception
 * @Description 全局异常处理
 */
public class BusinessException extends RuntimeException {
    // 把原本的异常类扩充了 两个 字段
    private static final long serialVersionUID = -5081099037620084926L;
    /**
     * 错误码
     */
    private final int code;
    /**
     * 详细描述
     */
    private final String description;

    public BusinessException(String message, int code, String description) {
        super(message);
        this.code = code;
        this.description = description;
    }

    public BusinessException(ErrorCode errorCode, String description) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
        this.description = description;
    }

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
        this.description = errorCode.getMessage();
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
