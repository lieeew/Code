package com.hspedu.web.iinterceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author leikooo
 * @create 2023-06-27 14:10
 * @Package com.hspedu.web.iinterceptor
 * @Description
 */
@Component
public class MyInterceptor01 implements HandlerInterceptor {

    /**
     * 1. 该方法在目标方法执行前，被执行
     * 2. 如果 preHandle() 返回 false，不在执行目标方法
     * 3. 该方法可以获取到 request，response，handler
     * 4. 可以根据业务进行拦截，指定跳转到哪一个页面
     *
     * @param request
     * @param response
     * @param handler
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyInterceptor01 的  preHandle() 方法执行了--");
        String keywords = request.getParameter("keywords");
        if ("病毒".equals(keywords)) {
            request.getRequestDispatcher("/WEB-INF/pages/warning.jsp").forward(request, response);
            return false;
        }

        System.out.println("keywords = " + keywords);

        return true;
    }


    /**
     * 1. 在目标方法执行后，会执行 postHandle()
     * 2. 该方法可以获取到 目标方法，返回 ModelAndView
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor01 的  postHandle() 方法执行了--");

    }

    /**
     * 视图渲染后被执行，可以做些资源清理工作
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MyInterceptor01 的  afterCompletion() 方法执行了~~");
    }
}
