package com.hspedu.SpringMVC.view;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * ClassName: MyView
 * Package: com.hspedu.SpringMVC.view
 *
 * @Author: leikooo
 * @Creat: 2023/6/11 - 10:34
 * @Description:
 */
@Component("hspView")
public class MyView extends AbstractView {

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 完成视图渲染
        // 并且决定调转的页面「请求转发」 /WEB-INF/pages/my_view.jsp
        System.out.println("进入到自己的视图~~");
        // 请求转发
        // /WEB-INF/pages/my_view.jsp 最终会被解析为 /工程路径/WEB-INF/pages/my_view.jsp
        request.getRequestDispatcher("/WEB-INF/page/my_view.jsp").forward(request, response);

    }
}
