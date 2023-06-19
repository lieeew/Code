import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hspedu.entity.Monster;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leikooo
 * @create 2023-06-18 8:12
 * @Package PACKAGE_NAME
 * @Description
 */
public class JacksonTest {
    public static void main(String[] args) throws JsonProcessingException {
        List<Monster> monsters = new ArrayList<>();
        monsters.add(new Monster(100, "牛魔王", 400, "芭蕉扇"));
        monsters.add(new Monster(200, "老猫怪", 700, "抓老鼠"));
        monsters.add(new Monster(300, "老魔王", 800, "抓老鬠"));
        monsters.add(new Monster(400, "白骨精", 900, "诱惑人"));
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(monsters);
        System.out.println(s);
    }

}
