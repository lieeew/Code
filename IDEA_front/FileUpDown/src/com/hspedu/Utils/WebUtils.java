package com.hspedu.Utils;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
}
