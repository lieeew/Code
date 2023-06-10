package com.hspedu.SpringMVC.vote;

import com.hspedu.SpringMVC.entity.Master;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        System.out.println("master = " + master);
        return "vote_ok";
    }

    @RequestMapping(value = "/vote04")
    public String test04(Master master, Map<String, String> map) {
        // 这个 Map 会放到 request 域中
        map.put("address", "beijing");
        return "vote_ok";
    }

}
