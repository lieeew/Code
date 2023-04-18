package com.hspedu.furns.web;

/**
 * @Author: qxy
 * @Date: 2023/4/16
 * @Description:
 */

import com.hspedu.furns.entity.Furn;
import com.hspedu.furns.service.FurnService;
import com.hspedu.furns.service.impl.FurnServiceImpl;
import com.hspedu.furns.utils.DataUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
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
        // 方式一
        // String name = request.getParameter("name");
        // String maker = request.getParameter("maker");
        // BigDecimal price = null;
        // int sales = 0;
        // int stock = 0;
        // try {
        //     // 这里有很多写法, 如果数据转化在new Furn()中, 那么就就可以直接把try + catch 套到new Furn()中
        //     // 之后SpringMVC 也有解决方案
        //     price = new BigDecimal(request.getParameter("price"));
        //     sales = Integer.parseInt(request.getParameter("sales"));
        //     stock = Integer.parseInt(request.getParameter("stock"));
        // } catch (Exception e) {
        //     // 把消息放到request域中
        //     request.setAttribute("mes", "输入的信息格式有误");
        //     request.getRequestDispatcher("/views/manage/furn_add.jsp").forward(request, response);
        //     return; // 不要忘了加一个return退出方法
        // }
        // String imgPath = "assets/images/product-image/6.jpg"; // 默认地址
        // if (furnService.add(new Furn(null, name, maker, price, sales, stock, imgPath))) {
        //     // 这里还是需要重新查询数据库, 所以还需要list方法
        //     // request.getRequestDispatcher("/manage/FurnServlet?action=list").forward(request, response);
        //     // 这里重定向的化就会, 防止重复加入的问题
        //     response.sendRedirect(request.getContextPath() + "/manage/FurnServlet?action=list");
        // } else {
        //     System.out.println("失败 ~~");
        // }

        // 方式二 使用BeanUtils对JavaBean自动封装
        /*
            需要注意一点
            像<input name="name" style="width: 60%" type="text" value="Name"/>
            的 name属性需要 和 JavaBean中的属性名称一致否则失败, 底层仍然数调用反射
         */
        // Furn furn = new Furn();
        // try {
        //     BeanUtils.populate(furn, request.getParameterMap());
        //     if (furnService.add(furn)) {
        //         response.sendRedirect(request.getContextPath() + "/manage/FurnServlet?action=list");
        //     } else {
        //         System.out.println("失败 ~~");
        //     }
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }

        // 封装上面的代码
        // 自动封装
        Furn furn = DataUtils.copyParamToBean(request.getParameterMap(), new Furn());
        if (furnService.add(furn)) {
            // 成功的话, 直接重定向, 防止刷新重新提交
            response.sendRedirect(request.getContextPath() + "/manage/FurnServlet?action=list");
        } else {
            System.out.println("失败 ~~");
        }
    }


    protected void del(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = DataUtils.pareseInt(req.getParameter("id"), 0);
        Furn furn = new Furn();
        furn.setId(id);
        if (furnService.deleteFurnById(furn)) {
            // 不要请求转发, 要重定向
            resp.sendRedirect(req.getContextPath() + "/manage/FurnServlet?action=list");
        } else {
            System.out.println("删除失败~");
        }
    }


    protected void show(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int i = DataUtils.pareseInt(req.getParameter("id"), 1);
        Furn furn = new Furn();
        furn.setId(i);
        ServletContext servletContext = this.getServletContext();
        servletContext.setAttribute("id", i);
        Furn furnById = furnService.getFurnById(furn);
        if (furnById == null) {
            System.out.println("未查询到数据");
        } else {
            req.setAttribute("furn", furnById);
            req.getRequestDispatcher("/views/manage/furn_update.jsp").forward(req, resp);
        }

    }


    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Furn furn = DataUtils.copyParamToBean(req.getParameterMap(), new Furn());
        int id = (int) this.getServletContext().getAttribute("id");
        furn.setId(id);
        if (furnService.updateFurnInfo(furn)) {
            // success
            resp.sendRedirect(req.getContextPath() + "/manage/FurnServlet?action=list");
        } else {
            System.out.println("Failure");
        }

    }
}
