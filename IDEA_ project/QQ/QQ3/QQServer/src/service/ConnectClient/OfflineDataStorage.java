package service.ConnectClient;

import common.Message;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/12/12 - 12 - 12
 * @Description: service.ConnectClient
 * 用来存储离线数据
 */
public class OfflineDataStorage {
    private static ConcurrentHashMap<String, ArrayList<Message>> concurrentHashMap = new ConcurrentHashMap<>(); // 存储离线数据

    /**
     * 把数据放在数组之中
     * @param Account 用户ID
     * @param message 消息
     */
    public static void addInformation(String Account, Message message) {
        ArrayList<Message> messages = new ArrayList<>();
        messages.add(0, message);
        concurrentHashMap.put(Account, messages);

    }

    /**
     * 删除数据
     * @param Account 用户ID
     */
    public static void removeInformation(String Account) {
        concurrentHashMap.remove(Account);
    }

    /**
     * 返回information
     * @param Account 用户ID
     * @return 返回message对象
     */
    public static Message getOneInformation(String Account) {
        ArrayList<Message> messages = concurrentHashMap.get(Account);
        Iterator<Message> iterator = messages.iterator();
        return iterator.next();
    }
    /**
     * 判断是否有离线信息
     * @param Account 用户ID
     * @return 是否有 true为是, false为否
     */
    public static boolean isLineForInformation(String Account) {
        if (concurrentHashMap.get(Account) != null) {
            return true;
        } else {
            return false;
        }
    }

}
