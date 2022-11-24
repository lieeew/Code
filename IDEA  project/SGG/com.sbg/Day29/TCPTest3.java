package Day29;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *3.从客户端发送文件给服务端，服务端保存到本地。并返回“发送成功”给
 * 客户端。并关闭相应的连接。
 * @Auther: QiuXinYu
 * @Date: 2022/11/23 - 11 - 23
 * @Description: Day29
 */
public class TCPTest3 {

    /**
     * 客户端
     */
    @Test
    public void client() {
        Socket socket = null;
        OutputStream outputStream = null;
        BufferedInputStream bufferedInputStream = null;
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 7788);
            outputStream = socket.getOutputStream();

            bufferedInputStream = new BufferedInputStream(new FileInputStream("雷电将军解密.jpg"));
            byte[] buffe = new byte[1024];
            int len;
            while ((len = bufferedInputStream.read(buffe)) != -1) {
                outputStream.write(buffe, 0, len);
            }

            socket.shutdownOutput();

            // 从服务器接数据
            InputStream inputStream = socket.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bytes = new byte[20];
            int len1;
            while ((len1 = inputStream.read(bytes)) != -1) {
                byteArrayOutputStream.write(bytes, 0, len1);
            }
            System.out.println(byteArrayOutputStream.toString());

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
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
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    /**
     * 服务端
     */
    @Test
    public void sever() {
        ServerSocket serverSocket = null;
        Socket accept = null;
        InputStream inputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            serverSocket = new ServerSocket(7788);

            accept = serverSocket.accept();
            inputStream = accept.getInputStream();
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("雷电将军-3.jpg"));

            byte[] buffer = new byte[1024];
            int len;
            while ((len = inputStream.read(buffer)) != -1) {
                bufferedOutputStream.write(buffer, 0, len);
            }

            // 服务器给客户回应
            OutputStream outputStream = accept.getOutputStream();
            outputStream.write("雷电将军你好美!".getBytes());

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (accept != null) {
                try {
                    accept.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}


