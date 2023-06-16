package com.hspedu.hspspringmvc.servlet;

import com.hspedu.hspspringmvc.annotation.RequestMapping;
import com.hspedu.hspspringmvc.handler.HspHandler;
import com.hspedu.hspspringmvc.ioc.HspWebApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ClassName: HspDispatcherServlet
 * Package: com.hspedu.hspspringmvc.servlet
 *
 * @Author: leikooo
 * @Creat: 2023/6/12 - 6:02
 * @Description: 前端控制器, 充当原生的 Servlet , 所以需要继承 HttpServlet
 */
public class HspDispatcherServlet extends HttpServlet {
    private HspWebApplicationContext hspWebApplicationContext = null;
    /**
     * 定义一个属性 HandlerList, 保存 Handler [url 和控制器方法的映射]
     */
    private final List<HspHandler> executeDispatch = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // System.out.println("OK-HspDispatcherServlet doPost() 被调用~");
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // System.out.println("OK-HspDispatcherServlet doGet() 被调用~");
        // 调用方法完成分发请求
        executeDispatch(req, resp);
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        // 通过 servletConfig 拿到 web.xml 文件中的 ContextConfigLocation 属性
        //     <init-param>
        //       <param-name>ContextConfigLocation</param-name>
        //       <param-value>classpath:hspSpringMVC.xml</param-value>
        //     </init-param>

        // 拿到的是这个 classpath:hspSpringMVC.xml
        String contextConfigLocation = servletConfig.getInitParameter("ContextConfigLocation");
        // 这里创建一下自己的 Spring 容器
        hspWebApplicationContext = new HspWebApplicationContext(contextConfigLocation);
        hspWebApplicationContext.init();
        // 完成 url 映射
        initHandlerList();
        System.out.println("executeDispatch = " + executeDispatch);

    }


    /**
     * 编写方法, 完成 url 和控制器方法的映射
     */
    private void initHandlerList() {
        if (hspWebApplicationContext.ioc.isEmpty()) {
            // 判断当前的 ioc 容器中是否为 null
            return;
        }

        // 遍历 ioc 容器的 bean 对象
        // 遍历 HashMap
        ConcurrentHashMap<String, Object> ioc = hspWebApplicationContext.ioc;
        for (Map.Entry<String, Object> entry : ioc.entrySet()) {
            Class<?> clazz = entry.getValue().getClass();
            // 取出所有的方法
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                // 判断该方法是否有 @RequestMapping 注解
                if (method.isAnnotationPresent(RequestMapping.class)) {
                    RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
                    // 这里可以使用工程路径 + url
                    // getServletContext().getContextPath() => /springmvc 相当于工程路径
                    // 有两个方案， 第一个方案就是直接配置 tomcat 的工程路径 写为 /
                    // 第二个方案， 是使用下面的方式 使用 getServletContext().getContextPath() => /springmvc 相当于工程路径
                    String url = "/hsp_SpringMVC" + requestMapping.value();
                    HspHandler hspHandler = new HspHandler(url, entry.getValue(), method);
                    executeDispatch.add(hspHandler);
                }
            }
        }
    }

    /**
     * 编写方法, 通过 request 对象
     * 如果没有返回 null
     */
    private HspHandler getHspHandler(HttpServletRequest request, HttpServletResponse response) {
        // 1. 先获取到用户的 uri 比如: http://localhost:8080/springmvc/monster/list
        // uri = /springmvc/monster/list
        // 这里会有一个问题 工程路径的问题
        String requestUri = request.getRequestURI();
        for (HspHandler dispatch : executeDispatch) {
            if (requestUri.equals(dispatch.getUrl())) {
                return dispatch;
            }
        }
        return null;
    }

    /**
     * 分发请求器
     */
    private void executeDispatch(HttpServletRequest request, HttpServletResponse response) {
        HspHandler hspHandler = getHspHandler(request, response);
        try {
            if (hspHandler == null) {
                response.getWriter().println("<h1>404 Not Found</h1>");
            } else {
                // 存在资源
                Method method = hspHandler.getMethod();
                method.invoke(hspHandler.getController(), request, response);
            }
        } catch (IOException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
