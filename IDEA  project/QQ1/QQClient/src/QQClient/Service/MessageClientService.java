package QQClient.Service;

import com.qqcommon.Message;
import com.qqcommon.MessageType;

import java.awt.*;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/29 - 11 - 29
 * @Description: QQClient.Service
 * 改类/独享 ,提供和消息相关的服务
 */
public class MessageClientService {


    /**
     * 私聊
     * @param count 内容
     * @param getterId 接收者id
     * @param senderId 发送者id
     */
    public void sendMessageToOne(String count, String getterId, String senderId) {
        Message message = new Message();
        message.setSender(senderId);
        message.setGetter(getterId);
        message.setContent(count);
        message.setMessageType(MessageType.MESSAGE_COME_MES); // 普通聊天消息
        message.setSentTime(new Date().toString());
        System.out.println("\n" + getterId + "对" + senderId + "说 : " + count);
        // 发给客户端数据
        try {
            Socket socket = new ManageClientConnectServiceThread().getThread(senderId).getSocket();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
