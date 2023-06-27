package com.hspedu.SpringMVC.upload;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author leikooo
 * @create 2023-06-28 6:50
 * @Package com.hspedu.SpringMVC.upload
 * @Description
 */
@Controller
public class FileUpload {
    /**
     * @param file      代表接受到的文件
     * @param request   request 请求
     * @param introduce 代表介绍
     */
    @RequestMapping("/fileUpload")
    public String fileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request, String introduce) throws IOException {

        // 接收到提交的文件名字
        String filename = file.getOriginalFilename();
        System.out.println("你上传的文件是 = " + filename);
        System.out.println("introduce = " + introduce);
        // 得到要把传的文件保存到哪一个路径   保存到的是 「out」工作目录
        String fileFullPath = request.getServletContext().getRealPath("/img/" + filename);
        // 创建文件
        File saveFile = new File(fileFullPath);

        file.transferTo(saveFile);
        return "success";
    }

}
