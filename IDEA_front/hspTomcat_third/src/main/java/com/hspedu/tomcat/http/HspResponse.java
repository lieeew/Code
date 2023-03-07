package com.hspedu.tomcat.http;

import com.sun.xml.internal.ws.message.StringHeader;

import javax.servlet.Servlet;
import java.io.OutputStream;

/**
 * @Author: qxy
 * @Date: 2023/3/6
 * @Description:
 */
public class HspResponse {
    private OutputStream outputStream = null;
    public static final String Header = "HTTP/2 200 OK\r\n" +
            "content-type: text/html;charset=UTF-8\r\n\r\n";

    public HspResponse(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }
}
