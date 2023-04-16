package com.hspedu.furns.web;

/**
 * @Author: qxy
 * @Date: 2023/4/16
 * @Description:
 */

import com.hspedu.furns.entity.Furn;
import com.hspedu.furns.service.FurnService;
import com.hspedu.furns.service.impl.FurnServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@WebServlet(name = "FurnServlet", urlPatterns = "/manage/FurnServlet")
public class FurnServlet extends BasicServlet {
    private FurnService furnService = new FurnServiceImpl();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }


    /**
     * 这里使用模板设计模式 +反射
     */
    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Furn> list = furnService.list();
        request.setAttribute("furns", list);
        request.getRequestDispatcher("/views/manage/furn_manage.jsp").forward(request, response);
    }


    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String maker = request.getParameter("maker");
        BigDecimal price = new BigDecimal(request.getParameter("price"));
        int sales = Integer.parseInt(request.getParameter("sales"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        String imgPath = "assets/images/product-image/6.jpg"; // 默认地址
        if (furnService.add(new Furn(null, name, maker, price, sales, stock, imgPath))) {
            // 这里还是需要重新查询数据库, 所以还需要list方法
            // request.getRequestDispatcher("/manage/FurnServlet?action=list").forward(request, response);
            // 这里重定向的化就会, 防止重复加入的问题
            response.sendRedirect(request.getContextPath() + "/manage/FurnServlet?action=list");
        } else {
            System.out.println("失败 ~~");
        }
    }

}
