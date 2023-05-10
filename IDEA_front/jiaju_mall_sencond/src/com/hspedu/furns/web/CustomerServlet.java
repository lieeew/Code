package com.hspedu.furns.web;

import com.hspedu.furns.entity.Furn;
import com.hspedu.furns.entity.Page;
import com.hspedu.furns.service.FurnService;
import com.hspedu.furns.service.impl.FurnServiceImpl;
import com.hspedu.furns.utils.DataUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * ClassName: CustomerServlet
 * Package: com.hspedu.furns.web
 *
 * @Author: leikooo
 * @Creat: 2023/5/9 - 6:21
 * @Description:
 */
@WebServlet(name = "CustomerServlet", urlPatterns = {"/customerServlet"})
public class CustomerServlet extends BasicServlet{
    private final FurnService furnService = new FurnServiceImpl();

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = DataUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = DataUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_DEFAULT_SIZE);
        Page page = furnService.page(pageSize, pageNo);
        req.getSession().setAttribute("page", page);
        // 请求转发到对应的页面
        req.getRequestDispatcher("/views/manage/furn_manage.jsp").forward(req, resp);
    }


    protected void pageForName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = DataUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = DataUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_DEFAULT_SIZE);

        Page page = furnService.page(pageSize, pageNo);
        req.getSession().setAttribute("pageForIndex", page);

        req.getRequestDispatcher("/views/customer/index.jsp").forward(req, resp);
    }

    protected void SearchInform(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // System.out.println("searchInform~~");
        int pageNo = DataUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = DataUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_DEFAULT_SIZE);
        Page page = furnService.page(pageSize, pageNo);
        String name = req.getParameter("name");
        ArrayList<Furn> furns = furnService.searchFurn(name);
        page.setFurns(furns);
        req.getSession().setAttribute("pageForIndex", page);
        req.getRequestDispatcher("/views/customer/index.jsp").forward(req, resp);
    }
}
