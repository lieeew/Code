package qqclient.service;

import java.util.HashMap;

/**
 * @Author: qxy
 * @Date: 2023/1/29 16
 * @Description: 管理线程的工具
 */
public class ManageClientConnectServiceThread {
    private static HashMap<String, clientConnectServiceThread> hm = new HashMap<>();

    /**
     * 添加线程
     */
    public static void addClientThread(String s, clientConnectServiceThread clientConnectServiceThread) {
        hm.put(s, clientConnectServiceThread);
    }

    /**
     * 通过指定id获取集合
     * @return 线程
     */
    public static clientConnectServiceThread getThread(String userId) {
        return hm.get(userId);
    }
}
