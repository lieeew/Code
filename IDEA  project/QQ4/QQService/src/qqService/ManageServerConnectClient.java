package qqService;

import java.util.HashMap;
import java.util.Set;

/**
 * @Author: qxy
 * @Date: 2023/1/29 23
 * @Description:
 */
public class ManageServerConnectClient {
    private static HashMap<String , serverConnectClientThread> hm = new HashMap<String, serverConnectClientThread>();

    /**
     * 添加方法
     */
    public static void addToMangeHp(String userId, serverConnectClientThread serverConnectClientThread) {
        hm.put(userId, serverConnectClientThread);
    }

    /**
     * 通过userId获取线程
     */
    public static serverConnectClientThread getThreadByUserId(String userId) {
        return hm.get(userId);
    }

    /**
     * 获取在线用户列表
     */
    public static String getOnlineThread() {
        Set<String> strings = hm.keySet();
        StringBuffer stringBuffer = new StringBuffer();
        for (String string : strings) {
            stringBuffer.append(string).append(" ");
        }
        return stringBuffer.toString();
    }
}
