package com.hspedu.tomcat.servlet;


import com.hspedu.tomcat.http.HspRequest;
import com.hspedu.tomcat.http.HspResponse;

/**
 * @Author: qxy
 * @Date: 2023/3/6
 * @Description:
 */
public interface HspServlet {
    void init() throws Exception;

    void service(HspRequest hspRequest, HspResponse hspResponse) throws Exception;


    void destroy();
}
