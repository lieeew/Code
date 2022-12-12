package ClientServer.service;

import com.sun.corba.se.pept.transport.ContactInfoList;
import common.User;

import java.util.HashMap;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/12/9 - 12 - 09
 * @Description: ClientServer.service
 * 管理线程为了以后的扩展, 便于管理
 */
public class ManageClientConnectServerThread {

    private static HashMap<String,clientConnectServiceThread > hashMap = new HashMap<>();

    public static HashMap<String, clientConnectServiceThread> getHashMap() {
        return hashMap;
    }

    public static clientConnectServiceThread getClientConnectService(String userId) {
        return hashMap.get(userId);
    }
    public static void addThreadToManage(String account , clientConnectServiceThread clientConnectServiceThread) {
            hashMap.put(account, clientConnectServiceThread);
    }
}
