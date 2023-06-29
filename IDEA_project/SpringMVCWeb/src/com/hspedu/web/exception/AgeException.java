package com.hspedu.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author leikooo
 * @create 2023-06-29 8:01
 * @Package com.hspedu.web.exception
 * @Description
 */
// 这个信息是在默认页面显示的内容
@ResponseStatus(reason = "年龄需要在 1 - 120 之间", value = HttpStatus.BAD_REQUEST)
public class AgeException extends RuntimeException {

    public AgeException() {
        ;
    }

    public AgeException(String message) {
        super(message);
    }
}
