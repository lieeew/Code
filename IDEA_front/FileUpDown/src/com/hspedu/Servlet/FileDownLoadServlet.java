package com.hspedu.Servlet;

/**
 * @Author: qxy
 * @Date: 2023/4/11
 * @Description:
 */

import org.apache.commons.io.IOUtils;
import sun.misc.BASE64Encoder;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

@WebServlet(name = "FileDownLoadServlet", urlPatterns = "/fileDownLoadServlet")
public class FileDownLoadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String downLoadFileName = request.getParameter("name");
        // System.out.println("name = " + downLoadFileName);
        // 一定要保证tomcat的out目录有download文件夹, 否则不行 就rebuild +restart
        // 编写目录是web下面的, 工作目录是out目录下的
        String downLoadPath = "/download/";
        String downLoadFullPath = downLoadPath + downLoadFileName;
        ServletContext servletContext = request.getServletContext();

        String mimeType = servletContext.getMimeType(downLoadFullPath);
        //  MIME type  ： mimeType = image/jpeg
        // System.out.println("mimeType = " + mimeType);
        // 设置MIME类型
        response.setContentType(mimeType);

        // 4. 给http响应，设置响应头 Content-Disposition
        //   这里考虑的细节比较多，比如不同的浏览器写法不一样，考虑编码
        //   ff 是 文件名中文需要 base64, 而 ie/chrome 是 URL编码
        //   这里我们不需要同学们记住，只需知道原理
        //   老韩解读
        //(1)如果是Firefox 则中文编码需要 base64
        //(2)Content-Disposition 是指定下载的数据的展示形式 , 如果attachment 则使用文件下载方式
        //(3)如果是其他(主流ie/chrome) 中文编码使用URL编码
        if (request.getHeader("User-Agent").contains("Firefox")) {
            // 火狐 Base64编码
            response.setHeader("Content-Disposition", "attachment; filename==?UTF-8?B?" +
                    new BASE64Encoder().encode(downLoadFullPath.getBytes("UTF-8")) + "?=");
        } else {
            // 其他(主流ie/chrome)使用URL编码操作
            response.setHeader("Content-Disposition", "attachment; filename=" +
                    URLEncoder.encode(downLoadFullPath, "UTF-8"));
        }

        // 创建输入输出流
        // 1) 创建一个和要下载的文件相关联, 关联输入流
        InputStream resourceAsStream = servletContext.getResourceAsStream(downLoadFullPath);
        // 2) 得到返回数据的输出流
        ServletOutputStream outputStream = response.getOutputStream();
        // 3) 使用工具类, 关联地输入流文件, 拷贝到输出流, 返回浏览器(客户端)
        // 这里的IOUtils 是 org.apache.commons.io 包下面的
        IOUtils.copy(resourceAsStream, outputStream);
    }
}
