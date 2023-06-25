package com.hspedu.SpringMVC;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * ClassName: ComputerHandler
 * Package: com.hspedu.SpringMVC
 *
 * @Author: leikooo
 * @Creat: 2023/6/7 - 15:13
 * @Description:
 */
@Controller
public class ComputerHandler {

    @PostMapping("/show")
    public String showComputer(String nums, String price, String brand) {
        System.out.println("nums = " + nums + ", price = " + price + ", brand = " + brand);
        return "showInfo";
    }

}
