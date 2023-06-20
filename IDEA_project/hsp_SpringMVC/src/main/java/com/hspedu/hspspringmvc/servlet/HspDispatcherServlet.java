package com.hspedu.hspspringmvc.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.hspedu.hspspringmvc.annotation.RequestMapping;
import com.hspedu.hspspringmvc.annotation.RequestParam;
import com.hspedu.hspspringmvc.annotation.ResponseBody;
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
import java.lang.reflect.Parameter;
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
        // System.out.println("executeDispatch = " + executeDispatch);

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
                // 拿到对应的目标方法的参数信息
                Class<?>[] parameterTypes = method.getParameterTypes();
                // 创建实参数数组
                // 创建一个 object 数组
                Object[] parameters = new Object[parameterTypes.length];
                // 遍历参数数组, 根据参数数组信息, 将实参填充到实参数组
                for (int i = 0; i < parameterTypes.length; i++) {
                    // 取出每一个形参类型
                    Class<?> parameterType = parameterTypes[i];
                    // 底层是使用的类型进行匹配, 这里简化了一下使用名字
                    if ("HttpServletResponse".equals(parameterType.getSimpleName())) {
                        parameters[i] = response;
                    } else if ("HttpServletRequest".equals(parameterType.getSimpleName())) {
                        parameters[i] = request;
                    }
                }
                // 这里是分发请求，处理中文乱码非常合适
                request.setCharacterEncoding("UTF-8");

                // 将 http 请求参数封装到 parameters 数组之中，要注意填充的时候的顺序问题

                // 1. 获取 http 请求的参数集合
                // 返回的 map 第一个参数 第一个为 http 请求的参数名
                // 返回的第二个参数 String[] 类型的数组 就像是 chatBox 可以传递多个值
                Map<String, String[]> parameterMap = request.getParameterMap();
                // 2. 将 parameterMap 遍历, 将参数填充到 parameters 数组中
                for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
                    String name = entry.getKey();
                    // 这里简化了， 不考虑多个值。只考虑类似 name=leikooo
                    String value = entry.getValue()[0];
                    // 我们需要得到请求的参数对应的目标方法对应的形参的 index
                    Integer index = getIndexRequestParameterIndex(method, name);
                    // 将参数填充到 parameters 数组中
                    if (index == null) {
                        // 没有加注解
                        // 思路 1. 得到目标方法的所有参数名称 -- 专门的方法获取参数
                        // 2. 得到目标方法的所有形参进行遍历，如果匹配直接放入
                        List<String> requestParameterNames = getRequestParameterNames(method);
                        for (int i = 0; i < requestParameterNames.size(); i++) {
                            if (name.equals(requestParameterNames.get(i))) {
                                parameters[i] = value;
                            }
                        }
                    } else {
                        parameters[index] = value;
                    }
                }

                /*
                    1. public Object invoke(Object obj, Object... args) 可以传入一个数组
                    2. 这里老师需要准备传递给目标方法的 实参 => 封装到形参数组 => 然后反射调用传递给目标方法
                 */
                Object invoke = method.invoke(hspHandler.getController(), parameters);

                if (invoke instanceof String) {
                    String viewName = (String) invoke;
                    if (viewName.contains(":")) {
                        // 如果包含返回的是包含：
                        String viewType = viewName.split(":")[0];
                        String viewPage = viewName.split(":")[1];
                        if ("forward".equals(viewType)) {
                            // 说明是请求转发
                            request.getRequestDispatcher(viewPage).forward(request, response);
                        } else if ("redirect".equals(viewType)) {
                            // 说明是重定向
                            response.sendRedirect(request.getContextPath() + viewPage);
                        }
                    } else {
                        request.getRequestDispatcher(viewName).forward(request, response);
                    }
                } else if (invoke instanceof ArrayList) {
                    if (method.isAnnotationPresent(ResponseBody.class)) {
                        response.setContentType("application/json;charset=utf-8");
                        // 如果标识了，表示要返回 json 数据
                        // String json = new Gson().toJson(invoke);
                        // 也可以使用 jackson 进行字符串的转化
                        ObjectMapper objectMapper = new ObjectMapper();
                        String json = objectMapper.writeValueAsString(invoke);
                        response.getWriter().println(json);
                    }
                }
            }
        } catch (IOException | IllegalAccessException | InvocationTargetException | ServletException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param method 目标方法
     * @param name   请求的参数名
     * @return 目标方法对一个的第几个形参
     */
    public Integer getIndexRequestParameterIndex(Method method, String name) {
        // 取函数参数
        Parameter[] parameters = method.getParameters();
        for (int i = 0; i < parameters.length; i++) {
            Parameter parameter = parameters[i];
            // 如果有 @RequestParam 注解的
            if (parameter.isAnnotationPresent(RequestParam.class)) {
                RequestParam requestParam = parameter.getAnnotation(RequestParam.class);
                if (name.equals(requestParam.value())) {
                    return i;
                }
            }
            // 如果没有对应的注解那么直接拿到 name
            // if (name.equals(parameter.getName())) {
            //     return i;
            // }
        }
        return null;
    }

    /**
     * 编写方法，得到目标的所有形参名称，并放到集合中返回
     */
    public List<String> getRequestParameterNames(Method method) {
        List<String> list = new ArrayList<>();
        // 获取到所有的参数名称
        // 在默认情况下 parameters
        // parameters.getName() 返回的名字不是形参真正的名字
        // 而是 [arg0, arg1, arg2, ....], 这里我们引入插件
        Parameter[] parameters = method.getParameters();
        for (Parameter parameter : parameters) {
            list.add(parameter.getName());
        }
        // System.out.println("parameters = " + list);
        return list;
    }

}
