package Day29;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/23 - 11 - 23
 * @Description: Day29
 */
public class TCPTest1 {

    /**
     * 客户端
     */
    @Test
    public void test() {
        OutputStream os = null;
        Socket socket = null;
        try {
            // 1 步骤一:  创建Socket对象, 指明服务器的ip和端口号
            InetAddress byName = InetAddress.getByName("127.0.0.1"); // 写对方的ip
            socket = new Socket(byName, 8899);
            // 2. 获取一个输出流, 用于数据输出
            os = socket.getOutputStream();
            // 3. 写入数据的操作
            os.write("客户端妹妹".getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (os != null) {
                try {
                    os.close();
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
    public void test3() {
        ServerSocket serverSocket = null;
        Socket accept = null;
        InputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            // 1.创建服务器端SeverSocket, 指明自己的ip和端口号
            serverSocket = new ServerSocket(8899);
            // 2. 调用accept()标示接收来自客户端的Socket
            accept = serverSocket.accept();
            // 3. 获取输入流
            inputStream = accept.getInputStream();
            // 4. 读取输入流中的数据
            byteArrayOutputStream = new ByteArrayOutputStream(); // 底层还是数组
            byte[] bytes = new byte[5];
            int len;
            while ((len = inputStream.read(bytes)) != -1) {
                byteArrayOutputStream.write(bytes, 0, len);
            }

            System.out.println(byteArrayOutputStream.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // 5. 资源的关闭
            if (byteArrayOutputStream != null) {

                try {
                    byteArrayOutputStream.close();
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
            if (serverSocket != null){

                try {
                    serverSocket.close();
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
    public void test2() {
        Socket accept = null;
        InputStreamReader inputStreamReader = null;
        try {
            ServerSocket sc = new ServerSocket(8899);

            accept = sc.accept();
            InputStream inputStream = accept.getInputStream();

            // 错误写法, 有中文可能会乱码
//        byte[] bytes = new byte[20];
//        int len;
//        while ((len = inputStream.read(bytes)) != -1) {
//            String str = new String(bytes, 0, len);
//            System.out.println(str);
//        }
            inputStreamReader = new InputStreamReader(inputStream);
            char[] chars = new char[20];
            int len;
            while ((len = inputStreamReader.read(chars)) != -1) {
                String s = new String(chars, 0, len);
                System.out.println(s);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (inputStreamReader != null) inputStreamReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                if (accept != null) accept.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }


}
