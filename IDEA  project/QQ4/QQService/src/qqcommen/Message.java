package qqcommen;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @Author: qxy
 * @Date: 2023/1/27 22
 * @Description: 客戶端和服務端之間發送的消息
 */
public class Message implements Serializable {
    private static final long serialVersionUID = -54667710L;
    private String sender; // 发送者
    private String getter; // 接收者
    private String content; // 消息内容
    private Timestamp timestamp; // 发送时间
    private MessageType messageType; // 发送消息类型

}
