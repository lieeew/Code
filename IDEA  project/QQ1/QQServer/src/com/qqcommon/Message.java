package com.qqcommon;

import java.io.Serializable;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/26 - 11 - 26
 * @Description: com.hspedu.qqcommon
 * 表示客户端和服务端放松的消息
 */
public class Message implements Serializable {
    static final long serialVersionUID = 71L;
    private String sender; // 发送者
    private String getter; // 接受者
    private String content; // 消息内容

    private String sentTime; // 发送时间
    private String messageType; // 消息类型 可以在接口中定义消息类型

    public Message() {
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
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

    public String getSentTime() {
        return sentTime;
    }

    public void setSentTime(String sentTime) {
        this.sentTime = sentTime;
    }
}
