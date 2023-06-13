package com.hspedu.controller;

import com.hspedu.hspspringmvc.annotation.Controller;
import com.hspedu.hspspringmvc.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * ClassName: MonsterController
 * Package: com.hspedu.controller
 *
 * @Author: leikooo
 * @Creat: 2023/6/12 - 12:45
 * @Description:
 */
@Controller
public class MonsterController {

    /**
     * 编写方法, 可以列出 Monster 列表
     */
    @RequestMapping("/monster/list")
    public void listMonster(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("MonsterController.list");
        // 设置编码和返回的类型
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            writer.println("<h1> 妖怪名单 </h1>");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
