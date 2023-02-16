import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: qxy
 */
public class MyTomcat {
    public static void main(String[] args) {
        OutputStream outputStream = null;
        FileInputStream fis = null;
        Socket socket = null;
        try {
            // 在 9999 端口监听
            ServerSocket serverSocket = new ServerSocket(9999);
            if (!serverSocket.isClosed()) {
                System.out.println("====我的web服务器在9999端口监听====");
                // 得到socket用于通信
                socket = serverSocket.accept();
                // io得到文件
                 File file = new File("src/hello.html");
                // System.out.println(file);
                fis = new FileInputStream(file);
                byte[] bytes = new byte[(int) file.length()];
                fis.read(bytes);
                // 发送文件, 返回给浏览器/客户端
                outputStream = socket.getOutputStream();
                outputStream.write(bytes);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Test
    public void test() {
        File file = new File("hello.html");
        System.out.println(file.length());
    }

}
