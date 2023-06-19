package com.hspedu.Controller;

import com.hspedu.Service.HspMonsterService;
import com.hspedu.Service.impl.HspMonsterServiceImpl;
import com.hspedu.entity.Monster;
import com.hspedu.hspspringmvc.annotation.Controller;
import com.hspedu.hspspringmvc.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author leikooo
 * @create 2023-06-18 14:30
 * @Package com.hspedu.Controller
 * @Description
 */
@Controller // 使用 @Controller 注解标识
public class MonsterController {

    private HspMonsterService monsterService = new HspMonsterServiceImpl();

    @RequestMapping("/monster/list")
    public void listMonsters(HttpServletRequest request, HttpServletResponse response) {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        try {
            List<Monster> monsters = monsterService.listMonsters();
            StringBuilder content = new StringBuilder("<h1>妖怪列表</h1>");
            content.append("<table width='500px' style='border-collapse:collapse' border='1px'>");
            for (Monster monster : monsters) {
                content.append("<tr><td>").append(monster.getId()).append("</td><td>").append(monster.getName()).append("</td><td>").append(monster.getSkill()).append("</td>");
            }
            content.append("</table>");
            response.getWriter().println(content);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
