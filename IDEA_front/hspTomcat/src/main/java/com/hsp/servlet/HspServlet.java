package com.hsp.servlet;

import com.hsp.http.HspRequest;
import com.hsp.http.HspResponse;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
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
