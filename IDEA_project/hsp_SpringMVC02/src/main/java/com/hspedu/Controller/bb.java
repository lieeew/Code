package com.hspedu.Controller;

import com.hspedu.hspspringmvc.annotation.RequestMapping;
import com.hspedu.hspspringmvc.annotation.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: bb
 * Package: com.hspedu.controller
 *
 * @Author: leikooo
 * @Creat: 2023/6/12 - 14:48
 * @Description:
 */
// @Service
public class bb {
    @RequestMapping("/bb")
    public void bb(HttpServletRequest request, HttpServletResponse response){
        try {
            response.getWriter().println("<h1> bb </h1>");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
