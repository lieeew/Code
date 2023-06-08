package com.hspedu.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * ClassName: UserHandler
 * Package: com.hspedu.web
 *
 * @Author: leikooo
 * @Creat: 2023/6/6 - 14:31
 * @Description:
 */
@RequestMapping("/user")
@Controller // 就是一个处理器/控制器
public class UserHandler {

    /**
     * 老韩解读
     * 1. method=RequestMethod.POST: 表示请求 buy 目标方法必须是post
     * 2. RequestMethod 四个选项 POST, GET, PUT, DELETE
     * 3. SpringMVC 控制器默认支持 GET 和 POST 两种方式
     * 4. buy() 方法请求的url http://localhost:8080/工程路径/user/buy
     */
    @RequestMapping(value = "/buy", method = RequestMethod.POST)
    public String buy() {
        System.out.println("购买商品");
        return "success";
    }

    /**
     * 1. params = "bookId" 表示请求目标参数的时候必须要给一个boolId 但是值没有限定
     * 2. search (String bookId) : 表示请求方法时, 携带的 bookId=100, 就会将请求携带的bookId 的 100 赋值给函数形参bookId
     */
    @RequestMapping(value = "/find", params = "bookId!=100", method = RequestMethod.GET)
    public String search(String bookId) {
        System.out.println("查询书籍 bookId= " + bookId);
        return "success";
    }

    /**
     * 要求可以配置 /user/message/aa, /user/message/aa/bb/cc
     */
    @RequestMapping("/message/**")
    public String im() {
        System.out.println("发送消息");
        return "success";
    }


    /**
     * 我 们 希 望 目 标 方 法 获 取 到 username 和 userid, value="/xx/{username}
     */
    @RequestMapping("/reg/{username}/{userid}")
    public String register(@PathVariable("username") String name, @PathVariable("userid") String id) {
        System.out.println("接收到参数--" + "username= " + name + "--" + "usreid= " + id);
        return "success";
    }

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String hi() {
        System.out.println("hi");
        return "success";
    }

//    @RequestMapping(value = "/hi")
//    public String hi2() {
//        System.out.println("hi");
//        return "success";
//    }
}
