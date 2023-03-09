package com.hspedu.cookie;

import javax.servlet.http.Cookie;

/**
 * @Author: qxy
 * @Date: 2023/3/9
 * @Description:
 */
public class CookieUtils {

    public static Cookie readCookieByName(String name, Cookie[] cookies) {
        if (cookies == null || cookies.length == 0 || "".equals(name) || name == null) {
            return null;
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(name)) {
                return cookie;
            }
        }
        return null;
    }
}
