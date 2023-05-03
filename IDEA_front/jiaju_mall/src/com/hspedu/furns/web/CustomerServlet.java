package com.hspedu.furns.web;

/**
 * @Author: qxy
 * @Date: 2023/4/21
 * @Description:
 */

import com.hspedu.furns.entity.Furn;
import com.hspedu.furns.entity.Page;
import com.hspedu.furns.service.FurnService;
import com.hspedu.furns.service.impl.FurnServiceImpl;
import com.hspedu.furns.utils.DataUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CustomerServlet", urlPatterns = "/CustomerServlet")
public class CustomerServlet extends BasicServlet {
    private FurnService furnService = new FurnServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }


    /**
     * 这里仍然是一个分页请求显示家具的信息api/方法
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = DataUtils.parseInt(req.getParameter("pageNo"), 1);
        // 没有传入的话, 默认的值是Page.PAGE_SIZE
        int pageSize = DataUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

        Page<Furn> page = furnService.page(pageNo, pageSize);
        StringBuffer url = new StringBuffer("CustomerServlet?action=page");
        page.setUrl(url.toString());
        req.setAttribute("page", page); // 直接含有超多数据
        req.getRequestDispatcher("/views/customer/index.jsp").forward(req, resp);
    }

    /**
     * 获取搜索时的分页数据
     */
    protected void pageByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = DataUtils.parseInt(req.getParameter("pageNo"), 1);
        // 没有传入的话, 默认的值是Page.PAGE_SIZE
        int pageSize = DataUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

        // 如果参数有name, 但是没带有值, 接收的是""
        // 如果没有传入参数name, 那么接收的就是null
        String name = req.getParameter("name");
        if (name == null) {
            name = "";
        }
        Page<Furn> page = furnService.pageByName(name, pageNo, pageSize);
        req.setAttribute("page", page);
        StringBuffer url = new StringBuffer("CustomerServlet?action=pageByName&name=");
        if (!"".equals(name)) {
            url.append(name);
        }
        page.setUrl(url.toString());
        // 这里可以直接使用page中的url代替
        // req.setAttribute("name", name);
        req.getRequestDispatcher("/views/customer/index.jsp").forward(req, resp);
    }
}
