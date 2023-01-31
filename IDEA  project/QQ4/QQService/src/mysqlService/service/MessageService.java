package mysqlService.service;

import mysqlService.dao.MessageDAO;
import qqcommen.MessageType;

/**
 * @Author: qxy
 * @Date: 2023/1/29 13
 * @Description:
 */
public class MessageService {
    private MessageDAO messageDAO = new MessageDAO();

    /**
     * 保存客户端之间的消息
     */
    public boolean saveMessage(String sender, String getter, String content, String messageType) {
        int update = messageDAO.update("insert into message values (null, ?, ?, ?, now(), ?, null, null, null)", sender, getter, content, messageType);
        return update > 0;
    }
}
