package com.hspedu.web.requestparam;

import com.hspedu.web.entity.Master;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * ClassName: VoteHandler
 * Package: com.hspedu.web.requestparam
 *
 * @Author: leikooo
 * @Creat: 2023/6/8 - 21:45
 * @Description: 演示
 */
@Controller
@RequestMapping("/vote")
public class VoteHandler {

    /**
     * 1. 获取超链接的数据 https://ip:port/工程路径/vote/vote01?user=xxx 后台接收不到信息
     * 2. @RequestParam(value = "name", required = false)
     * 3. @RequestParam 表示提交的参数  value="name" 表示提交的参数
     * 4. required = false 表示参数可以没有, 默认是true, 表示必须要有
     * 5. 当我们使用这个参数之后, 请求的参数名和方法的形参就可以不一致
     * @param username
     * @return
     */
    @RequestMapping(value = "/vote01")
    public String test01(@RequestParam(value = "name", required = false) String username) {
        System.out.println("得到的username = " + username);
        return "success";
    }

    @RequestMapping("/vote02")
    public String test02(@RequestHeader(value = "Accept-Encoding") String ae, @RequestHeader("Host") String host) {
        System.out.println("ae = " + ae + "; host = " + host);
        return "success";
    }

    /**
     * 1. 方法的形参用对应的类型就会自动封装
     * 2. 如果自动完成封装, 要求提交的数据, 参数名和对象的字段名保持一致
     * 3. 如果属性是对象, 这里就任然是通过 字段名.字段
     * 比如Master中的 Pet 属性, 提交的参数名是 pet.id  pet.name
     * 4. 如果提交的参数和字段不匹配, 那么对象的属性值就是null
     */
    @RequestMapping("/vote03")
    public String test03(Master master) {
        System.out.println("master = " + master);
        return "success";
    }

    @RequestMapping("/vote04")
    public String test04(HttpServletRequest request, HttpServletResponse response, HttpSession hs) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("password = " + password + " username = " + username);

        HttpSession session = request.getSession();
        System.out.println(session == hs); // true
        return "success";
    }

    /**
     * 1. 演示将提交的数据 -> 封装到成 Java 对象 -> SpringMVC 会自动将其放入到 request 域中
     * 2. 这样我们就可以在跳转的页面取出数据, 属性名是 类型首字母小写
     * @return
     */
    @RequestMapping("/vote05")
    public String test05(Master master100, HttpServletRequest request, HttpServletResponse response) {
        /*
         1. SpringMVC会自动把获取的model模型, 放入到 request 域中, 名字就是master
         2. 也可以手动实现
         */
        // 手动放入属性
        request.setAttribute("address", "beijing");
        // 由于是传入的是地址值, 所以这里修改之后 request域中的数据也会修改
        // 如果我们希望修改master属性
        master100.setName("nono");
        // 分析一下SpringMVC中默认存放的的对象到 request 域中
        // 属性名是 类型首字母小写
        return "vote_ok";
    }

    @RequestMapping("/vote06")
    public String test06(Map<String, Object> map, Master master) {
        // 老师需求 通过Map对象, 添加属性到 request 中
        // 原理分析: SpringMVC 会遍历 map 中的 k-v 放到 request 中
        map.put("address", "shanghai~");
//         如果我们把 master 设置为 null  -->  结果前端拿不到数据
        map.put("master", null);
        return "vote_ok";
    }

    /**
     * 将 model 放入到 ModelAndView 对象中，实现将数据放入到request 域中
     */
    @RequestMapping("/vote07")
    public ModelAndView test07(Master master) {
        ModelAndView modelAndView = new ModelAndView();
        // 将属性放入到 ModelAndView
        modelAndView.addObject("address", "shanghai~");
        // 这样会到导致 master 变成 null
//        modelAndView.addObject("master", null);
        // 这里指的调转视图的名称
        // 也可以从数据库得到数据 -> 对象 -> 放入到视图 [Service-DAO-DB]
        modelAndView.setViewName("vote_ok");
        // 返回结果
        return modelAndView;
    }

    /**
     * 将 model(master 对象) 放入到 session 域中
     */
    @RequestMapping("/vote08")
    public String test09(Map<String, Object> map, Master master, HttpSession session) {
        // master 对象默放置到 request 域
        // 我们将 master 对象放入倒 session 域
        session.setAttribute("master", master);
        session.setAttribute("address", "guangzhou");
        return "vote_ok";
    }


    /**
     * 老韩解读
     * 1. 当在某个方法上，增加了@ModelAttribute 注解
     * 2. 那么在调用该 Handler 的任何一个方法时，都会先调用这个方法
     * 3. 类似于我们 Spring 讲解的 AOP 机制
     * 4. prepareModel 前置方法, 会切入到其他方法前执行
     */
    @ModelAttribute
    public void prepareModel() {
        System.out.println("prepareModel() ------完成前置通知----");
    }

}
