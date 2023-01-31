package qqService;

import qqcommen.Message;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author: qxy
 * @Date: 2023/1/31 12
 * @Description: 离线消息
 */
public class OffLineService {
    private static HashMap<String, ArrayList<Message>> hm = new HashMap<>();

    /**
     * 转存消息
     */
    public static void saveMessageForOffLine(String userId, Message message) {
        ArrayList<Message> messages = new ArrayList<>();
        messages.add(0, message);
        hm.put(userId, messages);
    }

    /**
     * 判断有离线无消息
     */
    public static boolean HaveOffLineMessage(String userId) {
        return hm.containsKey(userId);
    }

    /**
     * 返回数据
     */
    public static Message getMessage(String userId) {
        for (ArrayList<Message> value : hm.values()) {
            for (Message message : value) {
                return message;
            }
        }
        return null;
    }
    /**
     * 删除消息
     */
    public static void removeMessage(String userId) {
        hm.remove(userId);
    }


}
