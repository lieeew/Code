package com.hsp;

import javax.servlet.ServletContext;

/**
 * @Author: qxy
 * @Date: 2023/2/22
 * @Description:
 */
public class ServletUtils {

    public static int count_nums(ServletContext servletContext) {

        // getAttribute从 ServletContext 的域属性空间中获取指定名称的数据。
        Integer visit_count = (Integer) servletContext.getAttribute("visit_count");
        if (visit_count == null) {
            visit_count = 1;
            servletContext.setAttribute("visit_count", 1);
        } else {
            visit_count = visit_count + 1;
            servletContext.setAttribute("visit_count", visit_count);
        }
        return visit_count;
    }
}
