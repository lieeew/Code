package com.hspedu.furns.web;

import com.hspedu.furns.entity.Furn;
import com.hspedu.furns.service.FurnService;
import com.hspedu.furns.service.impl.FurnServiceImpl;
import com.hspedu.furns.utils.DataUtils;
import com.hspedu.furns.utils.WebUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
    // protected void updateFurn(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //     int id = DataUtils.parseInt(req.getParameter("id"), 0);
    //     Furn furnAfterUpdate = DataUtils.copyParamToBean(req.getParameterMap(), new Furn());
    //     furnAfterUpdate.setId(id);
    //     if (furnService.updateFurn(furnAfterUpdate)) {
    //         req.getRequestDispatcher("/FurnServlet?action=showFurn").forward(req, resp);
    //     } else {
    //         System.out.println("修改失败");
    //     }
    // }

    // 更新家居信息
    protected void updateFurn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = DataUtils.parseInt(request.getParameter("id"), 0);
        int pageNo = DataUtils.parseInt(request.getParameter("pageNo"), 1);
        Furn furn = furnService.getFurnById(id);
        if (furn == null) {
            // 没有登录, 直接请求转达到登录页面
            response.sendRedirect(request.getContextPath() + "/views/manage/manage_login.jsp");
            return;
        }
        if (ServletFileUpload.isMultipartContent(request)) {
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
            ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
            servletFileUpload.setHeaderEncoding("UTF-8");
            try {
                List<FileItem> list = servletFileUpload.parseRequest(request);
                for (FileItem fileItem : list) {
                    if (fileItem.isFormField()) {
                        // 如果只是文本文件
                        if (fileItem.isFormField()) {
                            // 如果是true就是文本 input text
                            String fieldName = fileItem.getFieldName();
                            if ("name".equals(fieldName)) {
                                furn.setName(fileItem.getString("utf-8"));
                            } else if ("stock".equals(fieldName)) {
                                furn.setStock(new Integer(fileItem.getString()));
                            } else if ("price".equals(fieldName)) {
                                furn.setPrice(new BigDecimal(fileItem.getString()));
                            } else if ("maker".equals(fieldName)) {
                                furn.setMaker(fileItem.getString("utf-8"));
                            }
                        }
                    } else { // 二进制文件
                        String name = fileItem.getName();
                        // System.out.println("name=" + name);
                        String filePath = WebUtils.upLoad(name, request);
                        // 将文件拷贝到FileStorageLocation目录
                        fileItem.write(new File(filePath));
                        // System.out.println(patch);
                        // System.out.println("imgPatch = " + imgPatch);
                        String assetsPath = "assets\\";
                        // 取出assets后面的路径
                        int index = filePath.indexOf(assetsPath);
                        String path = filePath.substring(index);
                        // 将反斜杠替换为斜杠
                        String finalPath = path.replace("\\", "/");
                        // System.out.println(finalPath);
                        // 把之前保存的图片删除
                        String realPathDel = request.getServletContext().getRealPath(furn.getImgPath());
                        // System.out.println("realPathDel = " + realPathDel);
                        if (!new File(realPathDel).delete()) {
                            System.out.println("原图片删除失败~");
                        }
                        furn.setImgPath(finalPath);
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        if (furnService.updateFurn(furn)) {
            request.setAttribute("pageNo", pageNo);
            request.getRequestDispatcher("/customerServlet?action=page").forward(request, response);
        } else {
            System.out.println("Furn更新失败~~");
        }
    }
}
