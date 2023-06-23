package com.hspedu.web.datavalid;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @author leikooo
 * @create 2023-06-22 19:53
 * @Package com.hspedu.web.datavalid
 * @Description
 */
@Controller
@Scope("prototype") // 多例, 每次请求 MonsterHandle 就会生成新的实例
public class MonsterHandle {

    @RequestMapping("/addMonsterUI")
    public String addMonsterUi(Map<String, Object> map) {
        /**老韩解读:
         1. 这里的表单，我们使用 springMVC 的标签来完成2. SpringMVC 表单标签在显示之前必须在 request 中有一个bean, 该bean的属性和表单标签的字段要对应!
         request 中的 key 为: form 标签的 modelAttribute 属性值，比如这里的monsters
         3. SpringMVC 的 form:form 标签的 action 属性值中的/ 不代表WEB应用的根目录.
         4. <form:form action="monster" method="POST" modelAttribute="monster">
         这 里 需 要 给 request 增 加 一 个 monster ，因为jsp 页面的 modelAttribute="monster" 需要
         这时是 springMVC 的内部的检测机制 即使是一个空的也需要，否则报错
         */
        map.put("monsters", new Monster());
        return "datavalid/monster_addUI";
    }

    /**
     * 1. SpringMVC 可以将提交的数据，按照参数名称和属性名匹配
     * 2. 直接封装到对象之中 --> 模型数据方面的知识
     * 3. @Valid Monster monster 表示要对 monster 接受的信息进行校验
     * 4. Errors errors 如果校验异常，错误信息就会被填充到这里
     * 5. Map<String, Object> map 如果校验异常，会保存错误信息和 monster 对象
     * 6. 校验发生的时机，是 SpringMVC 底层反射调用 http 请求的数据，然后根据注解进行验证，如果出现了错误那么就把错误信息填充到 errors 和 map 中
     * 编写方法，处理添加妖怪
     */
    @RequestMapping("/saveMonsters")
    public String save(@ModelAttribute("monsters") @Valid Monster monsters, Errors errors, Map<String, Object> map) {
        map.put("monsters", monsters);
        System.out.println("monster = " + monsters);
        System.out.println("====map====");
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
        }

        System.out.println("===errors====");
        if (errors.hasErrors()) {//判断是否有错误
            List<ObjectError> allErrors = errors.getAllErrors();
            for (ObjectError error : allErrors) {
                System.out.println("error=" + error);
            }
            return "datavalid/monster_addUI";
        }
        return "datavalid/success";
    }

}
