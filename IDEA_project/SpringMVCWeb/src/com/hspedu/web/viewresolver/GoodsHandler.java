package com.hspedu.web.viewresolver;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName: GoodsHandler
 * Package: com.hspedu.web.viewresolver
 *
 * @Author: leikooo
 * @Creat: 2023/6/10 - 7:30
 * @Description:
 */
@Controller
@RequestMapping("/goods")
public class GoodsHandler {

    @RequestMapping("/buy")
    public String buy() {
        System.out.println("----buy----");
        // 待会填写自定义是视图的名称
        return "hspView";
    }

//    @RequestMapping("/order")
//    public String order() {
//        System.out.println("请求转发 ~ ");
//        // forward:/WEB-INF/pages/vote_ok.jsp 会被解析为 /工程路径/WEB-INF/pages/vote_ok.jsp
//        return "forward:/WEB-INF/pages/vote_ok.jsp";
////        return "forward:/login.jsp";
//    }

    @RequestMapping("/order")
    public String order() {
        System.out.println("重定向 ~ ");
        // 不能重定向到 /WEB-INF/ 目录下
//        return "redirect:/WEB-INF/pages/vote_ok.jsp";
        return "redirect:/login.jsp";
    }

}
