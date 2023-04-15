package com.hspedu.furns.web.manage;

/**
 * @Author: qxy
 * @Date: 2023/4/15
 * @Description:
 */

import com.hspedu.furns.entity.Furns;
import com.hspedu.furns.service.FurnsService;
import com.hspedu.furns.service.impl.FurnsServiceImpl;
import com.sun.deploy.panel.ITreeNode;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FurnServlet", urlPatterns = "/manage/furnServlet")
public class FurnServlet extends FurnBasicServlet {
    private FurnsService furnsService = new FurnsServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    // @Override
    // protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //     String action = request.getParameter("action"); // page
    //     String pageNo = request.getParameter("pageNo"); // 1
    //
    //     HttpSession session = request.getSession();
    //     String status = (String) session.getAttribute("status");
    //     if ("SUCCESS".equals(status)) { // 检查是否验证的账号和密码
    //         List<Furns> furnInfor = furnsService.getFurnInfor();
    //         request.setAttribute("page", furnInfor);
    //         request.setAttribute("pageNo", pageNo);
    //         request.getRequestDispatcher("/views/manage/furn_manage.jsp").forward(request, response);
    //     } else {
    //         // 重定向到 登录界面
    //         response.sendRedirect(request.getContextPath() + "/views/manage/manage_login.jsp");
    //     }
    // }

    protected void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean delete = furnsService.delete(new Furns(id, null, null, null, null, null, null));
        if (!delete) {
            System.out.println("删除失败");
        } else {
            System.out.println("删除成功");
        }
    }

    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action"); // page
        String pageNo = request.getParameter("pageNo"); // 1

        HttpSession session = request.getSession();
        String status = (String) session.getAttribute("status");
        if ("SUCCESS".equals(status)) { // 检查是否验证的账号和密码
            List<Furns> furnInfor = furnsService.getFurnInfor();
            request.setAttribute("page", furnInfor);
            request.setAttribute("pageNo", pageNo);
            request.getRequestDispatcher("/views/manage/furn_manage.jsp").forward(request, response);
        } else {
            // 重定向到 登录界面
            response.sendRedirect(request.getContextPath() + "/views/manage/manage_login.jsp");
        }
    }

}
