package com.hspedu.tomcat.http;

import java.io.OutputStream;

/**
 * @Author: qxy
 * @Date: 2023/3/4
 * @Description:
 */

/*
 1. HspQuest 对象可以封装OutPutStream(和socket关联地)
 2. 即都可以通过 HspResponse对象 返回Http响应给服务器/客户端
 3. HspResponse对象 的作用等价于原生的servlet的HspResponse
 */
public class HspResponse {
    private OutputStream outputStream = null;
    // Http的响应头 先死后活
    public static final String respHeader = "HTTP/1.1 200 OK\r\n" +
            "Content-Type: text/html;charset=utf-8\r\n\r\n";

    // 传入的是和socket关联地
    public HspResponse(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    /**
     * 当我们需要返回输出流时, 可以使用这个方法
     */
    public OutputStream getOutputStream() {
        return outputStream;
    }
}