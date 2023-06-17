package com.hspedu.controller;

import com.hspedu.hspspringmvc.annotation.Controller;
import com.hspedu.hspspringmvc.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author leikoo
 *
 */
@Controller
public class OrderController {

    /**
     * 编写方法是打印order
     */
    @RequestMapping("/order/list")
    public void getOrder(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html;charset=utf-8");
        try {
            response.getWriter().write("订单列表");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("/order/add")
    public void addOrder(HttpServletRequest request, HttpServletResponse response){
        // 设置编码格式
        response.setContentType("text/html;charset=utf-8");
        try {
            response.getWriter().write("添加订单");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
