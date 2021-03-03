package BSTCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
    创建BS版本的TCP服务器
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        //创建一个服务器ServerSocket，和系统要指定的端口号
        ServerSocket server = new ServerSocket(8080);
        //使用accept方法获取到请求的客户端对象（对象）
        Socket socket = server.accept();
        //使用Socket对象中的方法getInputStream，获取网络字节输入流
        InputStream is = socket.getInputStream();
        //使用网络字节输入流InputStream对象中的方法read读取客户端的请求信息
//        byte[] bytes = new byte[1024];
//        int len = 0;
//        while ((len = is.read(bytes)) != -1) {
//            System.out.println(new String(bytes,0,len));
//        }
        /*
            浏览器打开：http://192.168.1.200:8080/Net/web/index.html
        */
        //把网络字节输入流对象，转换为字符缓冲输入流
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        //把客户端的请求信息的第一行读取出来
        String line = br.readLine();
        String[] arr = line.split(" ");
        String htmlpath = arr[1].substring(1);
        //创建一个本地字节输入流，构造方法中要绑定读取的HTML路径
        FileInputStream fis = new FileInputStream(htmlpath);
        OutputStream os = socket.getOutputStream();
        os.write("HTTP/1.1 200 OK\r\n".getBytes());
        os.write("Content-Type:text/html\r\n".getBytes());
        // 必须要写入空行,否则浏览器不解析
        os.write("\r\n".getBytes());

        //一读一写复制文件，把服务读取的HTML文件回写到客户端
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = fis.read(bytes)) != -1) {
            os.write(bytes,0,len);
        }
        fis.close();
        socket.close();
        server.close();
    }
}
