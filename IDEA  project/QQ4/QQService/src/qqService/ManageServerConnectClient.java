package qqService;

import java.util.HashMap;

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
}
