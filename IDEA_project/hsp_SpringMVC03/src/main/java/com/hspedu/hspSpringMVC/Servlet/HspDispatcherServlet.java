package com.hspedu.hspSpringMVC.Servlet;

import com.google.gson.Gson;
import com.hspedu.hspSpringMVC.annotation.RequestMapping;
import com.hspedu.hspSpringMVC.annotation.RequestParam;
import com.hspedu.hspSpringMVC.context.HspWebApplicationContext;
import com.hspedu.hspSpringMVC.handler.HspHandler;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @author leikooo
 * @create 2023-06-20 14:34
 * @Package com.hspedu.hspSpringMVC.Servlet
 * @Description
 */
public class HspDispatcherServlet extends HttpServlet {
    private HspWebApplicationContext hspWebApplicationContext = null;

    /**
     * 使用一个类记录 url 和控制器之间的关系
     */
    private final Map<String, HspHandler> handlerMapping = new ConcurrentHashMap<>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            executeDispatch(req, resp);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        String configureXML = config.getInitParameter("configureXML");
        hspWebApplicationContext = new HspWebApplicationContext();
        hspWebApplicationContext.loadXmlConfig(configureXML.split(":")[1]);
        initHandlerMapping(config.getServletContext().getContextPath());
        System.out.println("handlerMapping = " + handlerMapping);

    }

    /**
     * 装配对应的 map 对象，实现找到对应的方法
     */
    public void initHandlerMapping(String applicationContext) {
        Map<String, Object> ioc = hspWebApplicationContext.ioc;

        if (ioc == null) {
            // 也可以直接抛出异常
            return;
        }

        for (Map.Entry<String, Object> entry : ioc.entrySet()) {
            Class<?> clazz = entry.getValue().getClass();
            // 获取对应 class 对象的所有的方法
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(RequestMapping.class)) {
                    HspHandler hspHandler = new HspHandler();

                    RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
                    String url = requestMapping.value();

                    hspHandler.setMethod(method);
                    hspHandler.setClazz(clazz);
                    // 放入到集合之中
                    handlerMapping.put(applicationContext + url, hspHandler);
                }
            }
        }
    }

    /**
     * 编写调用方法
     */
    public void executeDispatch(HttpServletRequest req, HttpServletResponse resp) throws InstantiationException, IllegalAccessException, InvocationTargetException, IOException, ServletException {
        String contextPath = req.getRequestURI();
        if (!handlerMapping.containsKey(contextPath)) {
            // 返回 404 NOT FOUND 页面
            resp.setContentType("text/html;charset=UTF-8");
            resp.setStatus(404);
            try {
                resp.getWriter().write("404 NOT FOUND");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        // 能够找到对应的 handler
        HspHandler hspHandler = handlerMapping.get(contextPath);
        Method method = hspHandler.getMethod();
        Class clazz = hspHandler.getClazz();
        Object instance = clazz.newInstance();

        if (hspWebApplicationContext.ioc.containsKey(StringUtils.uncapitalize(clazz.getSimpleName()))) {
            instance = hspWebApplicationContext.ioc.get(StringUtils.uncapitalize(clazz.getSimpleName()));
        }


        Class<?>[] parameterTypes = method.getParameterTypes();
        // 创建一个形参数组
        Object[] args = new Object[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i] == HttpServletRequest.class) {
                args[i] = req;
            } else if (parameterTypes[i] == HttpServletResponse.class) {
                args[i] = resp;
            }
        }

        // 这里是分发请求，处理中文乱码非常合适
        req.setCharacterEncoding("UTF-8");

        Map<String, String[]> reqParameterMap = req.getParameterMap();
        for (Map.Entry<String, String[]> entry : reqParameterMap.entrySet()) {
            String key = entry.getKey();
            Integer index = getParamIndex(method, key);
            if (index == null) {
                index = getParamIndexByName(method, key);
            }
            // 简化了
            args[index] = entry.getValue()[0];
        }

        // 调用方法
        Object invoke = method.invoke(instance, args);

        // 判断返回值的类型
        if (invoke instanceof String) {
            String url = (String) invoke;
            if (url.contains(":")) {
                String manner = url.split(":")[0];
                if ("redirect".equals(manner)) {
                    resp.sendRedirect(req.getContextPath() + url.split(":")[1]);
                } else if ("forward".equals(manner)) {
                    req.getRequestDispatcher(url.split(":")[1]).forward(req, resp);
                }
            }
        } else if (invoke instanceof ArrayList) {
            ArrayList list = (ArrayList) invoke;
            resp.setContentType("application/json;charset=UTF-8");
            resp.getWriter().write((new Gson()).toJson(list));
        }
    }

    /**
     * 获取对应注解标识 @RequestParam 标识的变量的 索引
     */
    public Integer getParamIndex(@NotNull Method method, @NotNull String name) {
        Parameter[] parameters = method.getParameters();
        for (int i = 0; i < parameters.length; i++) {
            if (parameters[i].isAnnotationPresent(RequestParam.class)) {
                RequestParam requestParam = parameters[i].getAnnotation(RequestParam.class);
                String value = requestParam.value();
                if (value.equals(name)) {
                    return i;
                }
            }
        }
        return null;
    }


    /**
     * 获取被 @RequestMapping 中的 index
     */
    public Integer getParamIndexByName(@NotNull Method method, @NotNull String name) {
        Parameter[] parameters = method.getParameters();
        for (int i = 0; i < parameters.length; i++) {
            Parameter parameter = parameters[i];
            String paramName = parameter.getName();
            if (paramName.equals(name)) {
                return i;
            }
        }
        return null;
    }
}
