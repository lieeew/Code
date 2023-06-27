package com.hspedu.SpringMVC.datavalid;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @author leikooo
 * @create 2023-06-25 21:28
 * @Package com.hspedu.SpringMVC.datavalid
 * @Description
 */
@Controller
@Scope("prototype")
public class MonsterHandler {

    @RequestMapping("/addMonsterUI")
    public String addMonsterUi(Map<String,Object> map){
        map.put("monster",new Monster());
        return "datavalid/monster_addUI";
    }

    @RequestMapping("/saveMonster")
    public String saveMonster(@ModelAttribute("monster") @Valid Monster monster, Errors errors, Map<String, Object> map){
        System.out.println("monster = " + monster);

        // 输出对应的 异常
        if (errors.hasFieldErrors()) {
            List<ObjectError> allErrors = errors.getAllErrors();
            for (ObjectError allError : allErrors) {
                System.out.println("allError = " + allError);
            }
        }

        System.out.println("---------------------");

        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println("entry.key = " + entry.getKey() + ", entry.value = " + entry.getValue());
        }
        if (errors.hasErrors()) {
            // 回显错误信息
            return "datavalid/monster_addUI";
        }
        return "datavalid/success";
    }




    @RequestMapping("/String2Int")
    public String String2Int(@RequestParam("age") int age){
        System.out.println(age);
        return "success";
    }

    /**
     * 取消绑定 monster 的 name 表单提交的值给 monster.name 属性
     */
//    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        // 需要注意把对应属性的验证的条件去掉
        dataBinder.setDisallowedFields("name");
    }

    public enum Status {
        ACTIVE, INACTIVE
    }

//    @RequestMapping("/enum")
    public String exampleMethod(@RequestParam("status") Status status) {
        System.out.println("status = " + status);
        // 使用转换后的枚举类型
        return "success";
    }

}
