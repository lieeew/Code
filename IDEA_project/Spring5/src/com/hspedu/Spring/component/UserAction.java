package com.hspedu.Spring.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * ClassName: UserAction
 * Package: com.hspedu.Spring.component
 *
 * @Author: leikooo
 * @Creat: 2023/5/21 - 21:40
 * @Description: 标识该类是一个控制器 Controller , 通常这个类是servlet
 */
@Controller
public class UserAction {

    // @Autowired

    /*

        1. @Resource(name = "userService") 表示装配的是 id=userService的对象
        2. 使用type属性, 需要保证对应的类就一个
        3. 如果不写的话, 先按 name 再按 type
     */
    @Autowired
    @Qualifier(value="userService200")
    private UserService userService200;

    public void sayOk() {
        System.out.println("UserAction sayOk()~");
        userService200.hi();
        System.out.println("UserAction 中的 userService的hash值是 = " + userService200);
    }

}
