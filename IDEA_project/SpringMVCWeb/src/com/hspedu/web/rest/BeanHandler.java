package com.hspedu.web.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName: BeanHandler
 * Package: com.hspedu.web.rest
 *
 * @Author: leikooo
 * @Creat: 2023/6/8 - 15:57
 * @Description:
 */
@Controller
@RequestMapping("/user")
public class BeanHandler {

    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    public String getBook(@PathVariable("id") String id) {
        System.out.println("查询的数据id = " + id);
        return "success";
    }

    @PostMapping("/book")
    public String addBook(String bookName) {
        System.out.println("添加的book的名字是 : " + bookName);
        return "success";
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.DELETE)
    public String deleteBook(@PathVariable("id") String id) {
        System.out.println("要删除的book的id = " + id);
//        return "success"; // JSPs only permit GET POST or HEAD
        // 使用重定向方式返回
        // 这里要注意会被解析为  /工程路径/user/success
        return "redirect:/user/success";
    }

    /**
     * 如果请求的是 /user/success , 转发到success.jsp
     * successGeneral 对应的url是 http://localhost:8080/工程路径/user/success
     * @return
     */
    @RequestMapping(value = "/success")
    public String successGeneral() {
        return "success";
    }

    @PutMapping("/book/{id}")
    public String updateBook(@PathVariable("id") String id) {
        System.out.println("需要update的 id = " + id);
        return "redirect:/user/success";
    }
}
