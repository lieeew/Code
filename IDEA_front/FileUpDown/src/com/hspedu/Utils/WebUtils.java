package com.hspedu.Utils;

import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @Author: qxy
 * @Date: 2023/4/10
 * @Description:
 */
public class WebUtils {

    public static String getYearMonthDay() {
        LocalDateTime ldt = LocalDateTime.now();
        int year = ldt.getYear();
        int month = ldt.getMonthValue();
        int day = ldt.getDayOfMonth();
        return year + "/" + month + "/" + day;
    }

    public static String upLoad(String name, ServletRequest request) {
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
        return fileRealPathDirectory + "/" + name;
    }
}
