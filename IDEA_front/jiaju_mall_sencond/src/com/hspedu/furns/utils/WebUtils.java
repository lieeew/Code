package com.hspedu.furns.utils;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @Author: qxy
 * @Date: 2023/5/2
 * @Description:
 */
public class WebUtils {

    public static String FURN_IMG_DIRECTORY = "assets/images/product-image";
    public static boolean isAjaxRequest(ServletRequest request) {
        HttpServletRequest req = (HttpServletRequest) request;
        return "XMLHttpRequest".equals(req.getHeader("X-Requested-With"));
    }

    public static String getYearMonthDay() {
        //如何得到当前的日期-> java基础 日期 三代类
        LocalDateTime ldt = LocalDateTime.now();
        int year = ldt.getYear();
        int monthValue = ldt.getMonthValue();
        int dayOfMonth = ldt.getDayOfMonth();
        String yearMonthDay = "/" + year + "/" + monthValue + "/" + dayOfMonth + "/";
        return yearMonthDay;
    }

    public static String upLoad(String name, ServletRequest request) {
        // 对名称进行二次改造
        name = UUID.randomUUID().toString() + System.currentTimeMillis() + "_" + name;
        // System.out.println();
        // 把这个上传到 服务器的 temp下的文件保存到你指定的目录
        // 1.指定一个目录 , 就是我们网站工作目录下
        String filePath = "/assets/images/product-image/";
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
