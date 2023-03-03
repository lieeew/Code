package com.hsp.http;

import java.io.OutputStream;

/**
 * @Author: qxy
 * @Date: 2023/2/28
 * @Description:
 */

/*
1. 他可以封装OutPutStream (是和socket关联)
2. 即可以通过HspServlet对象 返回http请求给浏览器/客户端
3. HspResponse对象 的作用等价于servlet中的HttpServletResponse

 */
public class HspResponse {
    private OutputStream outputStream = null;
    // 这个是http的响应头, 先死后活
    public static final String respHeader = "HTTP/1.1 200 OK\r\n" +
            "Content-Type: text/html;charset=utf-8\r\n\r\n";

    // 這個outputStream是和socket關聯的
    public HspResponse(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    // 当我们流浏览器要放回数据时, 可以通过HspResponse的输出流完成(和socket关联的)
    public OutputStream getOutputStream() {
        return outputStream;
    }

}
