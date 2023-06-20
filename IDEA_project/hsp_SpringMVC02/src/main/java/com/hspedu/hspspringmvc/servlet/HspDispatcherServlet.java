package com.hspedu.hspspringmvc.servlet;

import com.hspedu.Controller.MonsterController;
import com.hspedu.hspspringmvc.annotation.RequestMapping;
import com.hspedu.hspspringmvc.annotation.RequestParam;
import com.hspedu.hspspringmvc.annotation.Resource;
import com.hspedu.hspspringmvc.context.HspWebApplicationContext;
import com.hspedu.hspspringmvc.handler.HspHandler;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.basic.BasicButtonUI;
import java.io.IOException;
import java.lang.reflect.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author leikooo
 * @create 2023-06-18 12:49
 * @Package com.hspedu.hspspringmvc.servlet
 * @Description 充当原生的 DispatcherServlet
 */
public class HspDispatcherServlet extends HttpServlet {
    private final MonsterController monsterController = new MonsterController();
    /**
     * 存放映射关系
     */
    private final Map<String, HspHandler> handlerMap = new ConcurrentHashMap();
    /**
     * 自定义的容器类
     */
    private HspWebApplicationContext hspWebApplicationContext = null;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // System.out.println("HspDispatcherServlet~");
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // monsterController.listMonsters(req, resp);
        executeMethod(req, resp);

    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        String contextConfigLocation = config.getInitParameter("contextConfigLocation");
        // 进行初始化，否者这个对象的属性值没有为 null
        hspWebApplicationContext = new HspWebApplicationContext();
        String xmlFile = contextConfigLocation.split(":")[1];
        // System.out.println("xmlFile = " + xmlFile);
        hspWebApplicationContext.init(xmlFile);
        autowired();
        initHandlerMapping();
        System.out.println("handlerMap = " + handlerMap);
    }

    /**
     * 初始化处理映射关系, 也就是 handlerMap
     */
    public void initHandlerMapping() {
        Map<String, Object> ioc = hspWebApplicationContext.getIoc();
        // 遍历 ioc 容器
        if (ioc.size() == 0) {
            return;
        }

        for (Map.Entry<String, Object> entry : ioc.entrySet()) {
            Class<?> clazz = entry.getValue().getClass();
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                // 写在里面比较合适 每一次都是新的对象
                HspHandler hspHandler = new HspHandler();
                if (method.isAnnotationPresent(RequestMapping.class)) {
                    hspHandler.setMethod(method);
                    // System.out.println("clazz = " + clazz);
                    // 放入的是 object 对象
                    hspHandler.setController(entry.getValue());
                    // 放入 url
                    RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
                    hspHandler.setUrl("/hsp_SpringMVC02" + requestMapping.value());
                    // 放入到
                    handlerMap.put(hspHandler.getUrl(), hspHandler);
                }
            }
        }
    }

    /**
     * 反射调用方法
     */
    public void executeMethod(HttpServletRequest req, HttpServletResponse resp) {
        String uri = req.getRequestURI();
        HspHandler hspHandler = handlerMap.get(uri);
        try {
            if (hspHandler == null) {
                resp.getWriter().println("<h1> 404 NOT FOUND </h1>");
                return;
            }

            Method method = hspHandler.getMethod();
            Object controller = hspHandler.getController();
            // System.out.println("controller = " + controller);
            Class<?>[] parameterTypes = method.getParameterTypes();
            // 实参数组
            Object[] parameters = new Object[parameterTypes.length];
            for (int i = 0; i < parameterTypes.length; i++) {
                if ("HttpServletRequest".equals(parameterTypes[i].getSimpleName())) {
                    parameters[i] = req;
                } else if ("HttpServletResponse".equals(parameterTypes[i].getSimpleName())) {
                    parameters[i] = resp;
                }
            }

            // 编写方法获取到对应属性的位置
            Map<String, String[]> reqParameterMap = req.getParameterMap();
            for (Map.Entry<String, String[]> entry : reqParameterMap.entrySet()) {
                String key = entry.getKey();
                Integer index = getIndex(method, key);
                if (index == null) {
                    // 如果不能成功，那么使用参数变量名字匹配
                    index = getIndexByName(method, key);
                }
                // 简化情况，默认只有
                parameters[index] = entry.getValue()[0];
            }

            method.invoke(controller, parameters);

        } catch (IllegalAccessException | InvocationTargetException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 自动注入属性
     */
    public void autowired() {
        Map<String, Object> ioc = hspWebApplicationContext.ioc;
        if (ioc.size() == 0) {
            return;
        }

        for (Map.Entry<String, Object> entry : ioc.entrySet()) {
            Object o = entry.getValue();
            Field[] fields = o.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Resource.class)) {
                    // 被修饰
                    field.setAccessible(true);
                    // 先拿到名字
                    String valueName = field.getName();
                    // 名字可以注入成功就用名字
                    if (ioc.containsKey(valueName)) {
                        try {
                            Object bean = ioc.get(valueName);
                            field.set(o, bean);
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        }

                    } else {
                        // 拿到属性的属性
                        Class<?> fieldType = field.getType();
                        // 属性名小写拿
                        Object bean = ioc.get(StringUtils.uncapitalize(fieldType.getSimpleName()));
                        if (null == bean) {
                            return;
                        }
                        try {
                            field.set(o, bean);
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
    }
    /**
     * 编写方法获取到对应属性的位置 index
     */
    public Integer getIndex(Method method, String name) {
        Parameter[] parameters = method.getParameters();
        for (int i = 0; i < parameters.length; i++) {
            Parameter parameter = parameters[i];
            if (parameter.isAnnotationPresent(RequestParam.class)) {
                String value = parameter.getAnnotation(RequestParam.class).value();
                if (name.equals(value)) {
                    return i;
                }
            }
        }
        return null;
    }

    /**
     * 注解没有找到就使用变量名称
     */
    public Integer getIndexByName(Method method, String name) {
        Parameter[] parameters = method.getParameters();
        for (int i = 0; i < parameters.length; i++) {
            Parameter parameter = parameters[i];
            if (name.equals(parameter.getName())) {
                return i;
            }
        }
        return null;
    }
}
