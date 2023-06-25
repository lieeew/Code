package com.hspedu.SpringMVC.homework;

import com.hspedu.SpringMVC.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.constraints.NotNull;

/**
 * ClassName: LoginHandler
 * Package: com.hspedu.SpringMVC.homework
 *
 * @Author: leikooo
 * @Creat: 2023/6/11 - 16:50
 * @Description:
 */
@Controller
@RequestMapping("/homework")
public class LoginHandler {

    @RequestMapping("/login")
    public String doLogin(@NotNull User user) {
        if ("hsp".equals(user.getUsername()) && "123".equals(user.getPassword())) {
            // 如果账号和密码正确就返回登录成功页面
            // 默认请求转发
            return "login_ok";
        } else {
            return "login_error";
        }
    }


}
