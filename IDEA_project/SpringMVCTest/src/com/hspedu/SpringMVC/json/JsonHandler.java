package com.hspedu.SpringMVC.json;

import com.hspedu.SpringMVC.json.entity.Dog;
import com.hspedu.SpringMVC.json.entity.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author leikooo
 * @create 2023-06-26 17:09
 * @Package com.hspedu.SpringMVC.json
 * @Description
 */
@Controller
//@ResponseBody // 表示本类的所有方法都返回 JSON 格式的数据
//@RestController // 这个的注解可以替代上面两个注解
public class JsonHandler {

    @RequestMapping("JSON/getJson")
    @ResponseBody // 这个就标识要返回的就是 JSON 数据
    public Dog getJson() {
        Dog dog = new Dog("小米XX", "东北");

        return dog;
    }

    @RequestMapping("JSON/getJson2")
    @ResponseBody
    public Dog getJson2(@RequestBody Dog dog) {
        System.out.println("dog = " + dog);
        return dog;
    }

    @RequestMapping("JSON/getJson3")
    @ResponseBody
    public User getUser(@RequestBody User user) {
        System.out.println("user = " + user);
        return user;
    }

    @RequestMapping("JSON/downLoadMessage")
    public ResponseEntity<byte[]> downLoadMessage(HttpSession session) throws IOException {
        InputStream inputStream = session.getServletContext().getResourceAsStream("img/1.jpg");
        byte[] bytes = new byte[inputStream.available()];
        // 把数据放入到 byte[] 数组
        inputStream.read(bytes);
        HttpStatus httpStatus = HttpStatus.OK;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Disposition", "attachment;filename=1.jpg");
        return new ResponseEntity<byte[]>(bytes, httpHeaders, httpStatus);
    }

}
