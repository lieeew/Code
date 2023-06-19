package com.hspedu.hspspringmvc.servlet;

import com.hspedu.Controller.MonsterController;
import com.hspedu.hspspringmvc.context.HspWebApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author leikooo
 * @create 2023-06-18 12:49
 * @Package com.hspedu.hspspringmvc.servlet
 * @Description 充当原生的 DispatcherServlet
 */
public class HspDispatcherServlet extends HttpServlet {
    private final MonsterController monsterController = new MonsterController();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HspDispatcherServlet~");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
        // monsterController.listMonsters(req, resp);

    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        String contextConfigLocation = config.getInitParameter("contextConfigLocation");
        HspWebApplicationContext hspWebApplicationContext = new HspWebApplicationContext();
        String xmlFile = contextConfigLocation.split(":")[1];
        // System.out.println("xmlFile = " + xmlFile);
        hspWebApplicationContext.init(xmlFile);
    }
}
