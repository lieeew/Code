package common;

import java.io.Serializable;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/12/8 - 12 - 08
 * @Description: common
 */
public class Message implements Serializable {
    private static final long serialVersionUID = 10L;
    private String getterId; // 接收者
    private String senderId; // 发送者
    private String count; // 发送的内容
    private String messageType; // 发送数据的类型
    private String sentTime; // 发送时间
    private byte[] bytes; // 字节数组
    private String des; // 存储到的文件
    private String src; // 源文件
    public Message() {
    }

    public String getGetterId() {
        return getterId;
    }

    public void setGetterId(String getterId) {
        this.getterId = getterId;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getSentTime() {
        return sentTime;
    }

    public void setSentTime(String sentTime) {
        this.sentTime = sentTime;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}
