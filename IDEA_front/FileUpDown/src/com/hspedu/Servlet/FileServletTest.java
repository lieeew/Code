package com.hspedu.Servlet;

/**
 * @Author: qxy
 * @Date: 2023/4/10
 * @Description:
 */

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FileServletTest", urlPatterns = "/FileServletTest")
public class FileServletTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (ServletFileUpload.isMultipartContent(request)) {

            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
            ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
            servletFileUpload.setHeaderEncoding("UTF-8");
            try {
                List<FileItem> list = servletFileUpload.parseRequest(request);
                // [name=自由女神.jpg, StoreLocation=D:\SOFT\apache-tomcat-8.0.50\temp\ upload_ff94f61_18769aa2923__7f85_00000000.tmp, size=75678bytes, isFormField=false, FieldName=pic,
                // name=null, StoreLocation=D:\SOFT\apache-tomcat-8.0.50\temp\ upload_ff94f61_18769aa2923__7f85_00000001.tmp, size=0bytes, isFormField=true, FieldName=name]
                // System.out.println(list);
                for (FileItem fileItem : list) {
                    if (fileItem.isFormField()) { // 如果只是文本文件
                        System.out.println("name = " + fileItem.getString("utf-8"));
                    } else { // 二进制文件
                        String name = fileItem.getName();
                        // System.out.println("name=" + name);

                        // 把这个上传到 服务器的 temp下的文件保存到你指定的目录
                        // 1.指定一个目录 , 就是我们网站工作目录下
                        String filePath = "/upload2/";
                        // 2. 获取到完整目录 [io/servlet基础]
                        //  这个目录是和你的web项目运行环境绑定的. 是动态.
                        // fileRealPath=E:\github\IDEA_front\FileUpDown\out\artifacts\FileUpDown_war_exploded\ upload2\
                        String fileRealPath = request.getServletContext().getRealPath(filePath); // 这里时servletContext()方法
                        // System.out.println("fileRealPath=" + fileRealPath);
                        // 创建目录, 存放文件, 这里可以实现老韩写的需求
                        File FileStorageLocation = new File(fileRealPath);
                        if (!FileStorageLocation.exists()) {
                            // 不存在就创建
                            FileStorageLocation.mkdirs();
                        }
                        // 将文件拷贝到FileStorageLocation目录
                        fileItem.write(new File(FileStorageLocation + "//" + name));

                        response.setContentType("text/html;charset=utf-8");
                        response.getWriter().write("上传成功");
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println(" 非 enctype=\"multipart/form-data\"");
        }

    }
}
