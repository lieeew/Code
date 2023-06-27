package com.hspedu.web.iinterceptor;

import com.hspedu.web.json.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author leikooo
 * @create 2023-06-27 14:48
 * @Package com.hspedu.web.iinterceptor
 * @Description
 */
@Controller
public class FurnHandler {


    @RequestMapping("/hi")
    public String hi() {
        System.out.println("FurnHandler 的 hi() 被执行~~");
        return "success";
    }

    @RequestMapping("/hello")
    public String hello(User user) {
        System.out.println("FurnHandler 的 hello() 被执行~~");
        return "success";
    }

    @RequestMapping("/ok")
    public String ok() {
        System.out.println("ok");
        return "success";
    }
}
