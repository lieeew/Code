package com.hsp.Tomcat.servlet;

import com.hsp.Tomcat.http.HspRequest;
import com.hsp.Tomcat.http.HspResponse;

import java.io.IOException;

/**
 * @Author: qxy
 * @Date: 2023/2/28
 * @Description: 先搭架子, 三个主要的方法
 */
public interface HspServlet {

    void init() throws Exception;


    void service(HspRequest request, HspResponse response) throws IOException;


    void destroy();

}
