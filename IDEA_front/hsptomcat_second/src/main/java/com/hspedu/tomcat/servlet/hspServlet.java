package com.hspedu.tomcat.servlet;

import com.hspedu.tomcat.http.HspResponse;
import com.hspedu.tomcat.http.HspRequest;

/**
 * @Author: qxy
 * @Date: 2023/3/4
 * @Description: 先搭结构
 */
public interface hspServlet {
    void init() throws Exception;

    void service(HspRequest request, HspResponse response) throws Exception;

    void destroy();

}
