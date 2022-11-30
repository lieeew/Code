package QQServer.server.Server;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/27 - 11 - 27
 * @Description: QQServer.server
 */
public class ManageClientThreads {
    private static HashMap<String, ServerConnectClientThread> hashMap = new HashMap<>();
    // 添加线程实例到 hashMap 之中

    public static void addClientThread(String userId, ServerConnectClientThread serverConnectClientThread) {
        hashMap.put(userId, serverConnectClientThread);
    }

    public static ServerConnectClientThread getClientThread(String userId) {
        return hashMap.get(userId);
    }

    public static void removeClientThread(String userId) {
        hashMap.remove(userId);
    }

    // 获取在线列表
    public static String  getOnlineUser() {
        Iterator<String> iterator = hashMap.keySet().iterator();
        String onlineUserList = "";
        while (iterator.hasNext()) {
            onlineUserList += iterator.next().toString() + " ";
        }
        return onlineUserList;
    }

}
