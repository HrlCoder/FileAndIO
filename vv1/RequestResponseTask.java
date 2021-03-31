package vv1;

import java.io.*;
import java.net.Socket;

public class RequestResponseTask implements Runnable {
    private final Socket socket;

    public RequestResponseTask(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            System.out.println("一条 TCP 连接已经建立");

            OutputStream outputStream = socket.getOutputStream();
            Writer writer = new OutputStreamWriter(outputStream,"UTF-8");
            PrintWriter pw = new PrintWriter(writer);

            Thread.sleep(10_000);
            //响应行
            pw.printf("HTTP/1.0 200 OK\r\n");
            //响应头
            pw.printf("Content-Type: text/html; charset=utf-8\r\n");
            //空行
            pw.printf("\r\n");
            //响应体
            pw.printf("<h1>社会性死亡</h1>");
            pw.flush();

            socket.close();
            System.out.println("一条 TCP 连接已经释放");
        } catch (IOException | InterruptedException exc) {
            exc.printStackTrace(System.out);
        }
    }
}
