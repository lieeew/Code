package service.ConnectClient;

import java.sql.ClientInfoStatus;
import java.util.HashMap;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/12/9 - 12 - 09
 * @Description: service.ConnectClient
 * 管理线程
 */
public class ManageClientThreads {
    private static HashMap<String, ServerConnectClientThread> hashMap = new HashMap<>();

    /**
     * 获取HashMap
     * @return 返回集合
     */
    public static HashMap<String, ServerConnectClientThread> getHashMap() {
        return hashMap;
    }


    /**
     *  添加线程到线程的集合
     * @param userId 用户
     * @param serverConnectClientThread 持有线程的对象
     */
    public static void addThreadToManage(String userId, ServerConnectClientThread serverConnectClientThread) {
        hashMap.put(userId, serverConnectClientThread);
    }

    /**
     * 返回对应的线程
     * @param userId 需要获取线程的id
     * @return 返回对应的对象
     */
    public static ServerConnectClientThread getThread(String userId) {
        return hashMap.get(userId);
    }


    /**
     * 删除某个用户的线程
     * @param userId 请求删除者的id
     */
    public static void removeThread(String userId) {
        hashMap.remove(userId);
    }
}
