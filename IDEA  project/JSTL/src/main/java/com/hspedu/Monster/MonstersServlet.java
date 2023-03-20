package com.hspedu.Monster;

/**
 * @Author: qxy
 * @Date: 2023/3/20
 * @Description:
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "MonstersServlet", urlPatterns = "/MonstersServlet")
public class MonstersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // System.out.println("就你离谱~~~");
        HashMap<Integer, Monster_> monsters = new HashMap<Integer, Monster_>();

        monsters.put(100, new Monster_(100, "小妖怪", "巡山的", 344.7));
        monsters.put(200, new Monster_(200, "大妖怪", "做饭的", 1345.7));
        monsters.put(300, new Monster_(300, "老妖怪", "打扫卫生", 12212.2));

        request.setAttribute("id", 100);
        request.setAttribute("monsters", monsters);

        request.getRequestDispatcher("/HomeWork/show.jsp").forward(request, response);

    }
}
