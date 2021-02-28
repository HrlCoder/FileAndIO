package TCP;

/*
    TCP通信的客户端：向服务器发送连接请求，给服务器发送数据，读取服务器回写数据
    套接字：包含了IP地址和端口号的网络单位
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        //创建一个客户端对象Socket，构造方法绑定服务器的IP地址和端口号
        Socket socket = new Socket("192.168.1.200",8888);
        //使用Socket对象中的方法getOutputStream()获取网络字节输出流OutputStream对象
        OutputStream os = socket.getOutputStream();
        //使用络字节输出流OutputStream对象中的方法write，给服务器发送数据
        os.write("你好服务器".getBytes());
        //使用Socket对象中的方法getInputStream()获取网络字节输入流对象
        //使用络字节输出流OutputStream对象中的方法read，读取服务器回写的数据
        InputStream is = socket.getInputStream();
        byte[] bytes = new byte[1024];
        // 4.2 据读取到字节数组中.
        int len = is.read(bytes);
        // 4.3 解析数组,打印字符串信息
        String msg = new String(bytes, 0, len);
        System.out.println(msg);
        //释放资源
        os.close();
        socket.close();
    }
}
