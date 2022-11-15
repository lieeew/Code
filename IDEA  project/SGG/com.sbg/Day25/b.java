package Day25;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/15 - 11 - 15
 * @Description: Day25
 */

public class b {
    public static void main(String[] args) {
        HashMap<String, ArrayList<Citizen>> map = new HashMap<String, ArrayList<Citizen>>();
        ArrayList<Citizen> list = new ArrayList<Citizen>();
        list.add(new Citizen("刘恺威"));
        list.add(new Citizen("杨幂"));
        list.add(new Citizen("小糯米"));
        map.put("刘恺威", list);
//        Set<KeyStore.Entry<String, ArrayList<Citizen>>> entrySet = map.entrySet();
//        Iterator<Map.Entry<String, ArrayList<Citizen>>> iterator = entrySet.iterator();
//        while (iterator.hasNext()) {
//            Map.Entry<String, ArrayList<Citizen>> entry = iterator.next();
//            String key = entry.getKey();
//            ArrayList<Citizen> value = entry.getValue();
//            System.out.println("户主：" + key);
//            System.out.println("家庭成员：" + value);
//        }
    }
}

