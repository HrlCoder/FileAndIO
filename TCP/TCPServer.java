package TCP;

/*
    TCP通信的服务器端L接受客户端的请求，读取客户端发送的数据，个客户端回写数据

    服务器端必须明确一件事，必须知道是哪个客户端请求的服务器
    所以可以使用accept方法获取到请求的客户端对象Socket
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        System.out.println("服务端启动 , 等待连接 .... ");
        // 1.创建 ServerSocket对象，绑定端口，开始等待连接
        ServerSocket serverSocket = new ServerSocket(8888);
        // 2.接收连接 accept 方法, 返回 socket 对象.
        Socket server = serverSocket.accept();
        // 3.通过socket 获取输入流
        InputStream is = server.getInputStream();
        // 4.一次性读取数据
        // 4.1 创建字节数组
        byte[] bytes = new byte[1024];
        // 4.2 据读取到字节数组中.
        int len = is.read(bytes);
        // 4.3 解析数组,打印字符串信息
        String msg = new String(bytes, 0, len);
        System.out.println(msg);
        OutputStream os = server.getOutputStream();
        os.write("收到谢谢".getBytes());
        //5.关闭资源.
        server.close();
        serverSocket.close();
    }
}
