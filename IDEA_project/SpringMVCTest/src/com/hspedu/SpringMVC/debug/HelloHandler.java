package com.hspedu.SpringMVC.debug;

import com.hspedu.SpringMVC.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author leikooo
 * @create 2023-06-30 6:23
 * @Package com.hspedu.SpringMVC.debug
 * @Description
 */
@Controller
public class HelloHandler {

    @RequestMapping("/hello")
    public String hello(User user, HttpServletRequest request) {
        System.out.println(user);
        request.setAttribute("hsp", "老师厉害");
        return "success";
    }
}
