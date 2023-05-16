package service.ConnectClient;

import common.Message;
import common.MessageType;
import service.utils.Utility;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/12/12 - 12 - 12
 * @Description: service.ConnectClient
 */
public class sendNewsToAll implements Runnable{


    @Override
    public void run() {
        while (true) {
            Message message = new Message();
            message.setMessageType(MessageType.SEND_MESSAGE_TO_ALL);
            message.setSenderId("服务器");
            message.setSentTime(new Date().toString());

            System.out.println("请输入你要发送的内容: (exit退出)");
            String content = Utility.readString(20);
            if (content.equals("exit")) {
                System.out.println("退出群发送系统！");
                break;
            }
            message.setCount(content);

            //将内容发送各个在线用户
            try {
                HashMap<String, ServerConnectClientThread> hashMap = ManageClientThreads.getHashMap();
                Iterator<String> iterator = hashMap.keySet().iterator();
                while (iterator.hasNext()) {
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(hashMap.get(iterator.next()).getSocket().getOutputStream());
                    objectOutputStream.writeObject(message);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
