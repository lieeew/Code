package com.hspedu.SpringMVC.vote;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName: GoodHandler
 * Package: com.hspedu.SpringMVC.vote
 *
 * @Author: leikooo
 * @Creat: 2023/6/11 - 10:48
 * @Description:
 */
@RequestMapping("/goods")
@Controller
public class GoodsHandler {

    @RequestMapping("/buy")
    public String buy() {
        System.out.println("----buy----");
        // 待会填写自定义是视图的名称
        return "hspView";
    }

    @RequestMapping("/forward")
    public String order() {
        System.out.println("请求转发~~");
        return "forward:/WEB-INF/page/my_view.jsp";
    }

    // 重定向到某一个页面
    @RequestMapping("/redirect")
    public String redirect() {
        System.out.println("重定向~~");
        // will have some trouble s to find the path of the file, It can not access /WEB-INF/
        return "redirect:/login.jsp";
    }

}
