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
    private String messageType; // 发送消息类型
    private byte[] bytes; // 字节数组
    private String src;
    private String desc;
    public Message() {
    }

    public Message(String sender, String getter, String content, Timestamp timestamp, String messageType) {
        this.sender = sender;
        this.getter = getter;
        this.content = content;
        this.timestamp = timestamp;
        this.messageType = messageType;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getGetter() {
        return getter;
    }

    public void setGetter(String getter) {
        this.getter = getter;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
