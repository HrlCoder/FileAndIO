package 文件上传优化;

/*
    文件上传案例的客户端L读取本地文件，上传到服务器，读取服务器回写的数据
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        //创建一个本地字节输入流FileInputStream对象，构造方法中绑定要读取的数据源


        FileInputStream fis = new FileInputStream("c:\\1.jpg");
        //创建一个客户端Socket对象，构造方法中八钢钉服务器的IP地址和端口号
        Socket socket = new Socket("192.168.1.200",8888);
        //使用Socket中的方法getOutputStream，获取 网络字节输出流OutputStream对象
        OutputStream os = socket.getOutputStream();
        //使用本地字节输入流FileInputStream对象中的read，读取本地文件
        int len = 0;
        byte[] bytes = new byte[1024];
        /**
         * fis.read(bytes)读取本地文件，结束标记是读取到-1结束
         * while循环不会读取到-1，那么也不会把结束标记写给服务器
         */
        while ((len = fis.read(bytes)) != -1) {
            //使用网络字节输出流OutputStream对象中的方法write，吧读取到的文件上传到服务器
            os.write(bytes,0,len);
        }
        /**
         * 解决方法：上传完文件，给服务器写一个结束标记
         */
        socket.shutdownOutput();
        //使用Socket中的方法getInputStream，获取网络字节输入流InputStream对象
        InputStream is = socket.getInputStream();
        //使用网络字节输入流InputStream对象中的方法read读取服务器回写的数据
        while ((len = is.read(bytes)) != -1) {
            System.out.println(new String(bytes,0,len));
        }
        //释放资源
        fis.close();
        socket.close();
    }
}
