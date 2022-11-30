package QQClient.Service;

import java.util.HashMap;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/27 - 11 - 27
 * @Description: QQClient.Service
 */
public class ManageClientConnectServiceThread {

    private static HashMap<String , clientConnectServiceThread> hm = new HashMap<>();

    public static void addClientConnectServerThread(String userId, clientConnectServiceThread clientConnectServiceThread) {
        hm.put(userId, clientConnectServiceThread);
    }

    public clientConnectServiceThread getThread(String userId) {
        return hm.get(userId);
    }

}
