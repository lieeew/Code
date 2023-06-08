package com.hspedu.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * ClassName: UserServlet
 * Package: com.hspedu.web
 *
 * @Author: leikooo
 * @Creat: 2023/6/6 - 6:23
 * @Description:
 * 1. 如果我们实现类SpringMVC框架, 在一个类上表识 @Controller
 * 2. 比原生简单
 */
@Controller
public class UserServlet {

    /**
     * 老韩解读
     * 1. login() 方法用于响应用户的登录请求
     * 2. @RequestMapping(value = "/login") 类似于原生的Servlet 配置的url-pattern
     * 3. 当用户在浏览器输入 http://localhost:8888/web工程目录/login, 就会访问到该方法
     * @return 表示结果返回给视图解析器, 视图解析器会根据配置 ,来决定找到那个页面
     *
     *     <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
     *         <property name="prefix" value="/WEB-INF/pages"/>
     *         <property name="suffix" value=".jsp" />
     *     </bean>
     *
     *     最终会去找
     *     /WEB-INF/pages/login_ok.jsp
     */
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @PostMapping("/login")
    public String login() {
        System.out.println("login ok ~");
        return "login_ok";
    }

}
