package com.hspedu.SpringMVC.interceptor;

import com.hspedu.SpringMVC.json.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author leikooo
 * @create 2023-06-28 14:07
 * @Package com.hspedu.SpringMVC.interceptor
 * @Description
 */
@Controller
public class HandlerText {

    @RequestMapping("/hi")
    public String hi() {
        System.out.println("HandlerText.hi");
        return "success";
    }


//    @RequestMapping("/hello")
//    public String hello(User user) {
//        System.out.println("HandlerText.hello");
//        return "success";
//    }

}
