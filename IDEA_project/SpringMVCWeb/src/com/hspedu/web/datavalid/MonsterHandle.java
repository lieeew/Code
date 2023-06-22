package com.hspedu.web.datavalid;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
     * 编写方法，处理添加妖怪
     */
    @RequestMapping("/saveMonster")
    public String save(Monster monster) {
        System.out.println("monster = " + monster);
        return "datavalid/success";
    }

}
