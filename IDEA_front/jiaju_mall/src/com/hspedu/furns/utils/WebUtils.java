package com.hspedu.furns.utils;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

/**
 * @Author: qxy
 * @Date: 2023/5/2
 * @Description:
 */
public class WebUtils {

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
        String yearMonthDay = year + "/" + monthValue + "/" + dayOfMonth + "/";
        return yearMonthDay;
    }
}
