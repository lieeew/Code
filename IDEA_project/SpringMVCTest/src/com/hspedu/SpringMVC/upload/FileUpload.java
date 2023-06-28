package com.hspedu.SpringMVC.upload;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author leikooo
 * @create 2023-06-28 6:50
 * @Package com.hspedu.SpringMVC.upload
 * @Description
 */
@Controller
public class FileUpload {

    @RequestMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file, String description, HttpServletRequest request) {
        System.out.println("description = " + description);
        String filename = file.getOriginalFilename();
        try {
            String filePath = request.getServletContext().getResource("/img/").getPath();
            File saveFile = new File(filePath + "/" + filename);
            file.transferTo(saveFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "success";
    }


}
