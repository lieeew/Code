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
import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.ArrayList;
import java.util.function.DoublePredicate;

/**
 * @Author: qxy
 * @Date: 2023/5/5
 * @Description:
 */
@WebServlet(name = "FurnServlet", urlPatterns = {"/FurnServlet"})
public class FurnServlet extends BasicServlet {
    private final FurnService furnService = new FurnServiceImpl();

    protected void showFurn(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Furn> furn = furnService.queryFurns();
        req.setAttribute("furn", furn);
        req.getRequestDispatcher("/views/manage/furn_manage.jsp").forward(req, resp);
    }


    // 显示要修改的家居信息
    protected void showUpdateFurn(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = DataUtils.parseInt(req.getParameter("id"), 0);
        Furn furn = furnService.getFurnById(id);
        req.setAttribute("furn", furn);
        // System.out.println("furn = " + furn);
        req.getRequestDispatcher("/views/manage/furn_update.jsp").forward(req, resp);
    }

    // 更新家居信息
    protected void updateFurn(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = DataUtils.parseInt(req.getParameter("id"), 0);
        Furn furnAfterUpdate = DataUtils.copyParamToBean(req.getParameterMap(), new Furn());
        furnAfterUpdate.setId(id);
        // System.out.println("furnClass = " + furnClass);
        // furnClass = Furn{id=null, name='leikooo', maker='LEIKOOO家具', price='666', sales=6666, stock=666, imgPatch='null'}
        if (furnService.updateFurn(furnAfterUpdate)) {
            req.getRequestDispatcher("/FurnServlet?action=showFurn").forward(req, resp);
        } else {
            System.out.println("修改失败");
        }
    }
}
