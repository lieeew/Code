package com.hspedu.SpringMVC.vote;

import com.hspedu.SpringMVC.entity.Master;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * ClassName: VoteHandler
 * Package: com.hspedu.SpringMVC.vote
 *
 * @Author: leikooo
 * @Creat: 2023/6/10 - 20:45
 * @Description:
 */
@Controller
@RequestMapping("/vote")
public class VoteHandler {

    /**
     * 测试传入的参数名不一致的情况
     */
    @RequestMapping(value = "/vote01")
    public String test01(@RequestParam(value = "id", required = false) String bookId,
                         @RequestParam(value = "name", required = false) String bookName) {
        System.out.println("bookId = " + bookId);
        System.out.println("bookName = " + bookName);

        return "success";
    }

    @RequestMapping(value = "/vote02")
    public String test03(@RequestHeader(value = "Accept-Encoding") String acceptEncoding, @RequestHeader(value = "Host") String host) {
        System.out.println("acceptEncoding = " + acceptEncoding);
        System.out.println("host = " + host);
        return "success";
    }

    @RequestMapping(value = "/vote03")
    public String test03(Master master) {
        // SpringMVC 放入的属性 K 是类名首字母小写
        System.out.println("master = " + master);
        return "vote_ok";
    }

    /**
     * @param master 这个会自动放到 request域中
     */
    @RequestMapping(value = "/vote04")
    public String test04(Master master, Map<String, String> map, HttpServletRequest request, HttpSession httpSession) {
        // 这个 Map 会放到 request域中
        // SpringMVC 会遍历 map 中的 k-v 放到 request 中
        map.put("address", "beijing");
        // 这里设置 master 的值那么, request域 中就会相应的修改

        // 使用原生的方式同样可以获取到
        System.out.println("request.getParameter(\"name\") = " + request.getParameter("name"));

        // 放入到 session 数据
        httpSession.setAttribute("address", "shanghai");
        return "vote_ok";
    }

    @RequestMapping("/vote05")
    public ModelAndView test05() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("address", "herb");
        // 也可以从数据库得到数据 -> 对象 -> 放入到视图 [Service-DAO-DB]
        // 从数据库取出数据用的比较多
        modelAndView.setViewName("vote_ok");
        return modelAndView;
    }

    @RequestMapping("/vote06")
    public String test06(HttpSession httpSession, Master master) {
        System.out.println("test06()~~");
        httpSession.setAttribute("address", "Beijing");
        httpSession.setAttribute("master", master);
        return "vote_ok";
    }


    /**
     * 调用该类的任意方法时都会调用这个函数 类似于 「AOP」
     */
    @ModelAttribute
    public void prepareModel() {
        System.out.println("prepareModel() ------完成前置通知----");
    }

}
