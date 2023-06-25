package com.hspedu.web.json;

import com.hspedu.web.json.entity.Dog;
import com.hspedu.web.json.entity.User;
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
import java.util.ArrayList;
import java.util.List;

/**
 * @author leikooo
 * @create 2023-06-24 17:17
 * @Package com.hspedu.web.json
 * @Description
 */
//@ResponseBody
//@Controller
@RestController
public class JsonHandler {

    /**
     * 1. @ResponseBody 表示返回的数据是 json 格式
     * 2. SpringMVC 底层根据 @ResponseBody 注解，返回指定的格式，根据 Http 请求进行处理
     * 3. 原生的 SpringMVC 使用了转换器
     */
    @RequestMapping("/json/dog")
//    @ResponseBody
    public Dog getJson() {
        // 返回对象
        Dog dog = new Dog();
        dog.setAddress("东北");
        dog.setName("小黄");
        return dog;
    }

    /**
     * 返回 dog 集合
     */
    @RequestMapping("/json/dogs")
//    @ResponseBody
    public List<Dog> getDogs() {
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("大黄狗", "小鑫的家"));
        dogs.add(new Dog("大黄狗1", "小鑫1的家"));
        dogs.add(new Dog("大黄狗2", "小鑫2的家"));
        dogs.add(new Dog("大黄狗3", "小鑫3的家"));
        return dogs;
    }

    @RequestMapping("/json/user")
//    @ResponseBody
    public User saveUser(@RequestBody User user) {
        // 将前台传来的数据按照 JSON 的对应格式返回
        System.out.println("user = " + user);
        return user;
    }

    @RequestMapping("/download")
    public ResponseEntity<byte[]> downloadFile(HttpSession session) throws IOException {
        // 1. 获取下载文件的 inputStream
        InputStream inputStream = session.getServletContext().getResourceAsStream("/img/2.jpg");
        // 2. 开辟一个存放 byte[] 可以至此二进制数据
        byte[] bytes = new byte[inputStream.available()];
        // 3. 将下载的文件数据读取到 byte[]
        inputStream.read(bytes);
        // 使用这个构造器:
        // public ResponseEntity(@Nullable T body, @Nullable MultiValueMap<String, String> headers, HttpStatus status)
        HttpStatus httpStatus = HttpStatus.OK;
        // 5. 创建 headers
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Disposition", "attachment;filename=2.jpg");
        return new ResponseEntity<>(bytes, httpHeaders, httpStatus);
    }
}
