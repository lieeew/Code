package com.hspedu.tomcat.http;

/**
 * @author 韩顺平
 * @version 1.0
 */

import java.io.OutputStream;

/**
 * 老师解读
 * 1. HspResponse对象可以封装OutputStream(是socket关联)
 * 2. 即可以通过 HspResponse对象 返回Http响应给浏览器/客户端
 * 3. HspResponse对象 的作用等价于原生的servlet的 HttpServletResponse
 */
public class HspResponse {

    private OutputStream outputStream = null;

    //写一个http的响应头 => 先死后活
    public static final String respHeader = "HTTP/1.1 200 OK\r\n" +
            "Content-Type: text/html;charset=utf-8\r\n\r\n";

    //说明同学们如果有兴趣, 在编写更多的方法
    //比如 setContentType

    //在创建 HspResponse 对象时，传入的outputStream是和Socket关联的
    public HspResponse(OutputStream outputStream) {
        this.outputStream = outputStream;
    }
    //当我们需要给浏览器返回数据时，可以通过HspResponse 的输出流完成
    //
    public OutputStream getOutputStream() {
        return outputStream;
    }
}
