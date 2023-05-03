package com.hspedu.furns.web;

/**
 * @Author: qxy
 * @Date: 2023/4/16
 * @Description:
 */

import com.hspedu.furns.entity.Furn;
import com.hspedu.furns.entity.Page;
import com.hspedu.furns.service.FurnService;
import com.hspedu.furns.service.impl.FurnServiceImpl;
import com.hspedu.furns.utils.DataUtils;
import com.hspedu.furns.utils.WebUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
            response.sendRedirect(request.getContextPath() + "/manage/FurnServlet?action=page&pageNo=" + request.getParameter("pageNo"));
        } else {
            System.out.println("失败 ~~");
        }
    }


    protected void del(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = DataUtils.parseInt(req.getParameter("id"), 0);
        Furn furn = new Furn();
        furn.setId(id);
        if (furnService.deleteFurnById(furn)) {
            // 不要请求转发, 要重定向
            resp.sendRedirect(req.getContextPath() + "/manage/FurnServlet?action=page&pageNo=" + req.getParameter("pageNo"));
        } else {
            System.out.println("删除失败~");
        }
    }


    protected void showFurn(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = DataUtils.parseInt(req.getParameter("id"), 1);
        int pageNo = DataUtils.parseInt(req.getParameter("pageNo"), 1);
        // System.out.println("pageNo=" + pageNo); // 3
        Furn furn = new Furn();
        furn.setId(id);
        // ServletContext servletContext = this.getServletContext();
        // servletContext.setAttribute("id", i);
        Furn furnById = furnService.getFurnById(furn);
        if (furnById == null) {
            System.out.println("showFurn ： 未查询到数据");
        } else {
            req.setAttribute("furn", furnById);
            req.setAttribute("pageNo", pageNo);
            req.getRequestDispatcher("/views/manage/furn_update.jsp").forward(req, resp);
        }

    }


    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Furn furn = DataUtils.copyParamToBean(req.getParameterMap(), new Furn());
        int pageNo = DataUtils.parseInt(req.getParameter("pageNo"), 1);
        // System.out.println("update = pageNo=" + pageNo);
        // 前端设置一个hidden标签就可以解决
        // int id = (int) this.getServletContext().getAttribute("id");
        // furn.setId(id);
        if (furnService.updateFurnInfo(furn)) {
            // success
            // 重定向, 可以防止重复修改
            resp.sendRedirect(req.getContextPath() + "/manage/FurnServlet?action=page&pageNo=" + pageNo);
        } else {
            System.out.println("Failure");
        }
    }


    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = DataUtils.parseInt(req.getParameter("pageNo"), 1);
        // 没有传入的话, 默认的值是Page.PAGE_SIZE
        int pageSize = DataUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

        Page<Furn> page = furnService.page(pageNo, pageSize);
        // List<Furn> items = page.getItems();
        // StringBuffer sb = new StringBuffer();
        // sb.append(pageNo);
        // page.setUrl(sb.toString());
        // System.out.println(page.getUrl()); // 1$第1页&第2页
        // System.out.println("page = pageNo = " + pageNo);
        req.setAttribute("page", page); // 直接含有超多数据
        req.getRequestDispatcher("/views/manage/furn_manage.jsp").forward(req, resp);
    }

    /**
     * 修改update方法, 实现文件的上传
     */
    protected void updateMore(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 如果表单是enctype="multipart/form-data" 那么request.getParameter("id")拿不到数据
        // String id = request.getParameter("id");
        // System.out.println("id = " + id);
        int id = DataUtils.parseInt(request.getParameter("id"), 0);
        int pageNo = DataUtils.parseInt(request.getParameter("pageNo"), 1);
        Furn furn = furnService.getFurnById(new Furn(id));
        if (furn == null) {
            System.out.println("不存在该用户~");
            return;
        }

        // 1. 判断是不是文件表单(enctype="multipart/form-data")
        if (ServletFileUpload.isMultipartContent(request)) {
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
            ServletFileUpload servletFileUpload =
                    new ServletFileUpload(diskFileItemFactory);
            // 解决接收到文件名是中文乱码问题
            servletFileUpload.setHeaderEncoding("utf-8");

            // 4. 关键的地方, servletFileUpload 对象可以把表单提交的数据text / 文件
            //   将其封装到 FileItem 文件项中
            //   老师的编程心得体会: 如果我们不知道一个对象是什么结构[1.输出 2.debug 3. 底层自动看到]
            try {
                List<FileItem> list = servletFileUpload.parseRequest(request);
                // System.out.println("list==>" + list);
                // 遍历，并分别处理=> 自然思路
                for (FileItem fileItem : list) {
                    if (fileItem.isFormField()) {// 如果是true就是文本 input text
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
                    } else {// 是一个文件
                        // 用一个方法
                        // 获取上传的文件的名字
                        String name = fileItem.getName();
                        // System.out.println("上传的文件名=" + name);

                        // 把这个上传到 服务器的 temp下的文件保存到你指定的目录
                        // 1.指定一个目录 , 就是我们网站工作目录下
                        String filePath = WebUtils.FURN_IMG_DIRECTORY;
                        // 2. 获取到完整目录 [io/servlet基础]
                        //  这个目录是和你的web项目运行环境绑定的. 是动态.
                        String fileRealPath = request.getServletContext().getRealPath(filePath);
                        // 3. 创建这个上传的目录=> 创建目录?=> Java基础
                        File fileRealPathDirectory = new File(fileRealPath);
                        if (!fileRealPathDirectory.exists()) {// 不存在，就创建
                            fileRealPathDirectory.mkdirs();// 创建
                        }
                        // 4. 将文件拷贝到fileRealPathDirectory目录
                        //   构建一个上传文件的完整路径 ：目录+文件名
                        //   对上传的文件名进行处理, 前面增加一个前缀，保证是唯一即可, 不错
                        name = UUID.randomUUID().toString() + "_" + System.currentTimeMillis() + "_" + name;
                        String fileFullPath = fileRealPathDirectory + "/" + name;
                        fileItem.write(new File(fileFullPath)); // 保存成功
                        // 到这里就图片赋值成功了
                        fileItem.getOutputStream().close();
                        furn.setImgPath(filePath + "/" + name);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // 完成上面对于furn代码的更新之后, 更新到DB数据层
        if (furnService.updateFurnInfo(furn)) {
            request.setAttribute("pageNo", pageNo);
            request.getRequestDispatcher("/views/manage/update_ok.jsp").forward(request, response);
        } else {
            System.out.println("失败了, 哥们");
        }
    }

}
