package QQClient.server;

import java.util.HashMap;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/30 - 11 - 30
 * @Description: QQClient.server
 */
public class ManageClientConnectServerThread {

    //我们把多个线程放入一个HashMap:集合
    private static HashMap<String, ClientConnectServerThread> hm = new HashMap<>();

    public static void addClientConnectServerThread(String userId, ClientConnectServerThread clientConnectServerThread) {
        hm.put(userId, clientConnectServerThread);
    }



}
