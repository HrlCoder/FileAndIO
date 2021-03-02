package 文件上传优化;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/*
    文件上传案例服务器端：读取客户端上传的文件，保存到服务器的硬盘，给客户端回写“上传成功”
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        //创建一个服务器ServerSocket对象，和系统要指定的端口号
        ServerSocket server = new ServerSocket(8888);
        //使用ServerSocket对象中的方法accept，获取到请求的客户端Socket对象

        /**
         * 让服务器一直处于监听状态（死循环accept）方法
         * 有一个客户端上传文件，就保存一个文件
         */
        while (true) {
            Socket socket = server.accept();

            /**
             * 使用多线程技术提高效率
             * 有一个客户端上传文件，我就开启一个线程
             */
            new Thread(new Runnable() {
                //完成文件上传
                @Override
                public void run() {
                    try {
                        //使用Socket对象在的方法getInputStream，获取到网络字节流InputStream对象
                        InputStream is = socket.getInputStream();
                        //判断f:\\upLoad,是否存在，不存在则创建
                        File file = new File("f:\\upload");
                        if(!file.exists()) {
                            file.mkdirs();
                        }

                        /**
                         * 自定义一个文件的命名规则，防止同名的文件被覆盖
                         * 规则：域名+毫秒值+随机数
                         */
                        String fileName = "hzw"+System.currentTimeMillis()+new Random().nextInt(999999)+".jpg";

                        //创建一个本地字节输出流FileOutputStream对象，构造方法中绑定要输出的目的地
                        FileOutputStream fos = new FileOutputStream(file+"\\"+fileName);
                        //使用网络字节输入流InputStream对象中的方法read，读取客户端上传的文件
                        int len = 0;
                        byte[] bytes = new byte[1024];
                        /**
                         * is.read(bytes)读取客户端上传的文件，永远你也读取不到文件的结束标记
                         * read方法进入到阻塞状态，一直死循环等待结束标记
                         */
                        while ((len = is.read(bytes)) != -1) {
                            //使用本地字节输出流FileOutputStream对象中的方法write，吧读取到的文件保存 到服务器的硬盘上
                            fos.write(bytes,0,len);
                        }
                        /**
                         * 代码就不会执行到这里，也不会给客户端回写上传成功
                         */
                        //使用Socket中的方法getOutputStream，获取网络字节输出流OutputStream对象
                        OutputStream os = socket.getOutputStream();
                        //使用网络字节输出流OutputStream对象中的方法write，给客户端回写上传成功
                        os.write("上传成功".getBytes());
                        //释放资源
                        fos.close();
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        //服务器就不用关闭了
//        server.close();
    }
}
