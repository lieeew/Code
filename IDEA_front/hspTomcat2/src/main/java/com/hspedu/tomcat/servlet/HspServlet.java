package com.hspedu.tomcat.servlet;

import com.hspedu.tomcat.http.HspRequest;
import com.hspedu.tomcat.http.HspResponse;

import java.io.IOException;

/**
 * @author 韩顺平
 * @version 1.0
 * 先搭建结构，后面在写内容
 * 老韩只保留了 三个核心方法声明
 */
public interface HspServlet {

    void init() throws Exception;

    void service(HspRequest request, HspResponse response) throws IOException;

    void destroy();
}
