package com.hspedu.Controller;

import com.hspedu.Service.HspMonsterService;
import com.hspedu.entity.Monster;
import com.hspedu.hspspringmvc.annotation.Controller;
import com.hspedu.hspspringmvc.annotation.RequestMapping;
import com.hspedu.hspspringmvc.annotation.RequestParam;
import com.hspedu.hspspringmvc.annotation.Resource;
import javax.servlet.ServletException;
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

    @Resource // 自动注入属性
    private HspMonsterService monsterService;

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

    /**
     * 使用名字来获取对应的对象
     */
    @RequestMapping("/monster/listByName")
    public void listMonsterByName(HttpServletRequest request, HttpServletResponse response) {
        response.setCharacterEncoding("utf-8");
        try {
            response.getWriter().println("listMonsterByName~");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("/monster/login")
    public void login(@RequestParam("monsterName") String username,
                      @RequestParam("monsterAge") String age, HttpServletRequest request, HttpServletResponse response) {
        response.setCharacterEncoding("utf-8");
        request.setAttribute("name", username);
        System.out.println("username = " + username);
        System.out.println("age = " + age);
        try {
            if ("leikooo".equals(username)) {
                request.getRequestDispatcher("/login_ok.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/login_fail.jsp").forward(request, response);
            }
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }


}
