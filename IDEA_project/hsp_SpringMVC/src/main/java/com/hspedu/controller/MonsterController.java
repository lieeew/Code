package com.hspedu.controller;

import com.hspedu.Service.MonsterService;
import com.hspedu.entity.Monster;
import com.hspedu.hspspringmvc.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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
    @AutoWired
    private MonsterService monsterService;

    /**
     * 编写方法, 可以列出 Monster 列表
     */
    @RequestMapping("/monster/list")
    public void listMonster(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("MonsterController.list");
        // 设置编码和返回的类型
        response.setContentType("text/html;charset=utf-8");

        List<Monster> monsters = monsterService.listMonster();
        StringBuilder res = new StringBuilder();
        res.append("<h1> 妖怪数据列表 : </h1>");
        res.append("<table border='2px' cellpadding='10px' cellspacing='0px' bgcolor='#cccccc>'");
        for (Monster monster : monsters) {
            res.append("<tr><td>妖总name : ").append(monster.getName()).append("</td>");
            res.append("<td>妖总id : ").append(monster.getId()).append("</td>");
            res.append("<td>妖总skill : ").append(monster.getSkill()).append("</td></tr>");
        }
        res.append("</table>");

        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            writer.println(res.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("/monster/param")
    public void findMonsterByName(HttpServletRequest request, HttpServletResponse response,
                                  String name) {
        // 设置编码和返回的类型
        response.setContentType("text/html;charset=utf-8");
        System.out.println("----接收到的 name ：" + name + "----");
        List<Monster> monsters = monsterService.listMonsterByName(name);
        StringBuilder res = new StringBuilder();
        res.append("<h1> 妖怪数据列表 : </h1>");
        res.append("<table border='2px' cellpadding='10px' cellspacing='0px' bgcolor='#cccccc>'");
        for (Monster monster : monsters) {
            res.append("<tr><td>妖总name : ").append(monster.getName()).append("</td>");
            res.append("<td>妖总id : ").append(monster.getId()).append("</td>");
            res.append("<td>妖总skill : ").append(monster.getSkill()).append("</td></tr>");
        }
        res.append("</table>");

        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            writer.println(res.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 处理妖怪登录的方法
     */
    @RequestMapping("/monster/login")
    public String login(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "monsterName") String mName) {
        System.out.println("mName = " + mName);
        request.setAttribute("name", mName);
        boolean login = monsterService.login(mName);
        if (login) {
            // return "redirect:/login_ok.jsp";
            // 测试默认效果
            return "/login_ok.jsp";
        } else {
            return "redirect:/login_fail.jsp";
        }
    }

    /**
     * json 返回
     * 1. 该方法返回的结果是给 SpringMVC 底层通过反射调用
     * 2. 我们在 SpringMVC 底层反射调用的位置，接受到的结果解析并返回 Json 数据
     * 3. 目标方法的形参是在 SpringMVC 底层通过封装好的「参数数组」传入的
     */
    @RequestMapping("/monster/listByJson")
    @ResponseBody // 标识返回给前端的值是 json 数据，后面需要处理
    public ArrayList<Monster> listMonsterByJson(HttpServletRequest request, HttpServletResponse response){
        return (ArrayList<Monster>) monsterService.listMonster();
    }
}
