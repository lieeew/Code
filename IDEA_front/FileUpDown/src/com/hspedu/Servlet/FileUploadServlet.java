package com.hspedu.Servlet;

/**
 * @Author: qxy
 * @Date: 2023/4/10
 * @Description:
 */

import com.hspedu.Utils.WebUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "FileUploadServlet", value = "/FileUploadServlet")
public class FileUploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
            前端核心代码 :
            <input type="file" name="pic" id="" value="" onchange="prev(this)"/>
            家居名: <input type="text" name="name"><br/>
            <input type="submit" value="上传"/>
         */

        // 1. 判断是不是文件表单(enctype="multipart/form-data")
        if (ServletFileUpload.isMultipartContent(request)) {
            // 2. 创建 DiskFileItemFactory 对象, 用于构建一个解析上传数据的工具对象
            //      将其封装到 FileItem 文件项中
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
            ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
            // 解决中文乱码问题
            servletFileUpload.setHeaderEncoding("UTF-8");
            try {
                List<FileItem> list = servletFileUpload.parseRequest(request);
                // System.out.println(list);
                // [name=photo-1485738422979-f5c462d49f74.jpg, StoreLocation=D:\SOFT\apache-tomcat-8.0.50\temp\ upload__428e5b7f_18768cda86f__7f35_00000000.tmp, size=348645bytes, isFormField=false, FieldName=pic,
                // name=null, StoreLocation=D:\SOFT\apache-tomcat-8.0.50\temp\ upload__428e5b7f_18768cda86f__7f35_00000001.tmp, size=0bytes, isFormField=true, FieldName=name]

                for (FileItem fileItem : list) {
                    if (!fileItem.isFormField()) { // 不是表单字段, 是二进制数据
                        String name = fileItem.getName();
                        // 对名称进行二次改造
                        name = UUID.randomUUID().toString() + System.currentTimeMillis() + "_" + name;
                        // System.out.println();
                        // 把这个上传到 服务器的 temp下的文件保存到你指定的目录
                        // 1.指定一个目录 , 就是我们网站工作目录下
                        String filePath = "/upload/";
                        // 获取真实的工作路径, 这个是变化的
                        String realPath = request.getServletContext().getRealPath(filePath);
                        // realPath = E:\github\IDEA_front\FileUpDown\out\artifacts\FileUpDown_war_exploded\ upload\
                        // System.out.println("realPath = " + realPath);
                        File fileRealPathDirectory = new File(realPath + WebUtils.getYearMonthDay());
                        // 判断有没有文件夹, 没有就创建一个文件
                        // Note that the mkdirs() method will not throw an exception if the directory already exists or cannot be created. It simply returns false in the latter case.
                        // Therefore, it's recommended to check the return value to ensure that the directory is actually created.
                        if (!fileRealPathDirectory.exists()) {
                            fileRealPathDirectory.mkdirs();
                        }
                        // 将文件拷贝到fileRealPathDirectory
                        // 构建了一个上传文件的位置 目录 + 文件名
                        String savePath = fileRealPathDirectory + "/" + name;
                        fileItem.write(new File(savePath));

                        response.setContentType("text/html;charset=utf-8");
                        response.getWriter().write("上传成功!!");
                    } else { // 是true就是存文本结构
                        String string = fileItem.getString("utf-8");
                        System.out.println("name: " + string);

                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        } else {
            System.out.println("不是文件表单...");

        }
    }
}
