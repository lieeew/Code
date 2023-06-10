package com.hspedu.SpringMVC;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * ClassName: UserAccount
 * Package: com.hspedu.SpringMVC
 *
 * @Author: leikooo
 * @Creat: 2023/6/7 - 8:20
 * @Description:
 */
@Controller
@RequestMapping("/user")
public class UserAccount {

    // 请求的地址比价简单 http://ip:port/user/login/小王/123
    @RequestMapping("/login/{username}/{password}")
    public String login(@PathVariable("username") String username,
                      @PathVariable("password") String password) {
        System.out.println("登录的账号是 : " + username + " 密码是 : " + password);

        return "success";
    }

    @RequestMapping("/login")
    public String login2(String username, String password) {
        System.out.println("登录的账号是 : " + username + " 密码是 : " + password);
        return "success";
    }

    // 这里得到的bookId会直接给到search()的形参
    @RequestMapping(value = "/search", params = {"bookId=100", "!bookName"})
    public String search(String bookId, String bookName) {
        System.out.println("bookId : " + bookId + " bookName : " + bookName);
        return "success";
    }

//    @RequestMapping("/message/aa/**")
//    public String im() {
//        System.out.println("im() ~~");
//        return "success";
//    }

    @RequestMapping("/message/aa/springMVC??")
    public String im2() {
        System.out.println("hello~");
        return "success";
    }

    @RequestMapping(value = "/book/{BookId}", method = RequestMethod.GET)
    public String searchBook(@PathVariable("BookId") String bookId) {
        // 获取资源
        System.out.println("查询的 bookId = " + bookId);
        return "success";
    }

    /**
     * 使用 post 创建新的资源
     */
    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public String creatBook(@RequestParam(value = "book", required = false) String bookName) {
        System.out.println("创建新的资源  bookName = " + bookName);
        return "success";
    }

    /**
     * 删除资源 delete
     */
    @RequestMapping(value = "/book/{bookName}", method = RequestMethod.DELETE)
    public String deleteBook(@PathVariable("bookName") String bookName) {
        System.out.println("需要删除的「bookName」 = " + bookName);
        // 需要重定向
        return "redirect:/user/success";
    }

    /**
     * 成功返回的页面
     */
    @RequestMapping(value = "/success")
    public String success() {
        return "success";
    }
}
