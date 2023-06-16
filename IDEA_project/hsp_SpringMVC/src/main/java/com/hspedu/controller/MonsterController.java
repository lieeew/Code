package com.hspedu.controller;

import com.hspedu.Service.MonsterService;
import com.hspedu.entity.Monster;
import com.hspedu.hspspringmvc.annotation.AutoWired;
import com.hspedu.hspspringmvc.annotation.Controller;
import com.hspedu.hspspringmvc.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
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
}
