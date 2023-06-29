package com.hspedu.web.debug;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author leikooo
 * @create 2023-06-29 12:30
 * @Package com.hspedu.web.debug
 * @Description
 */
@Controller
public class HelloHandler {

    @RequestMapping("/debug/hello")
    public ModelAndView hello(HttpServletRequest request, HttpServletResponse response) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ok");
        // 向 model 中放入数据
        modelAndView.addObject("hsp", "HelloHandler");
        return modelAndView;
    }

}
