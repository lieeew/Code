package com.hsp.HomeWork.response;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: qxy
 * @Date: 2023/2/24
 * @Description: 把String -> int 并且 解决异常
 */
public class WebUtils {
    public static int transfer(String str, HttpServletResponse response) {
        int i = 0;
        try {
            i = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter writer = null;
            try {
                writer = response.getWriter();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } finally {
                writer.println("<h1>请输入正确的格式!!</h1>");
                writer.flush();
                writer.close();
            }
        }
        return i;
    }
}
