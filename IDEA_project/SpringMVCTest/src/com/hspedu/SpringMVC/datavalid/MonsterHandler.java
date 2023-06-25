package com.hspedu.SpringMVC.datavalid;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String saveMonster(@ModelAttribute("monster") Monster monster){
        System.out.println("monster = " + monster);
        return "datavalid/success";
    }

    
}
