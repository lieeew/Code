package qqclient.service;

import java.util.HashMap;

/**
 * @Author: qxy
 * @Date: 2023/1/29 16
 * @Description: 管理线程的工具
 */
public class ManageClientConnectServiceThread {
    private static HashMap<String, clientConnectServiceThread> hm = new HashMap<>();

    public static void addClientThread(String s, clientConnectServiceThread clientConnectServiceThread) {
        hm.put(s, clientConnectServiceThread);
    }
}
