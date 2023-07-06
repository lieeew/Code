package com.yupi.user_center.common;

/**
 * @author leikooo
 * @create 2023-07-06 19:55
 * @Package com.yupi.user_center.common
 * @Description
 */
public class ResultUtils {

    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(0, data, "OK");
    }

}
