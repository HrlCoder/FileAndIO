package vv2;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RequestResponseTask implements Runnable {
    private static final String DOC_BASE= "E:\\IdeaProjects\\比特-code\\HTTP\\docBase";
    private final Socket socket;

    public RequestResponseTask(Socket socket) {
        this.socket = socket;
    }

    private static final Map<String,String> mineTypeMap = new HashMap<>();
    static {
        mineTypeMap.put("txt","text/plain");
        mineTypeMap.put("html","text/html");
        mineTypeMap.put("js","application/javascript");
        mineTypeMap.put("jpg","image/jpeg");
    }
    @Override
    public void run() {
        try {
            System.out.println("一条 TCP 连接已经建立");

            //进行HTTP请求->解析出路径
            InputStream inputStream = socket.getInputStream();
            Scanner sc = new Scanner(inputStream,"UTF-8");
            sc.next();
            String path = sc.next();
            System.out.println(path);

            //设置默认路径
            if(path.equals("/")) {
                path = "/index.html";
            }

            String filePath = DOC_BASE + path;
            File resourse = new File(filePath);
            if(resourse.exists()) {
                //读取文件内容
                OutputStream outputStream = socket.getOutputStream();
                Writer writer = new OutputStreamWriter(outputStream,"UTF-8");
                PrintWriter pw = new PrintWriter(writer);

                String contentType = "text/plain";
                if(path.contains(".")) {
                    int i = path.lastIndexOf(".");
                    String suffix = path.substring(i+1);
                    contentType = mineTypeMap.getOrDefault(suffix,contentType);
                }

                if(contentType.startsWith("text/")) {
                    contentType = contentType+";charset=utf-8";
                }

                pw.printf("HTTP/1.0 200 OK\r\n");
                pw.printf("Content-Type:%s\r\n",contentType);
                pw.printf("\r\n");
                pw.flush();

                try(InputStream resourceInputStream = new FileInputStream(resourse)) {
                    byte[] buffer = new byte[1024];
                    while (true) {
                        int len = resourceInputStream.read(buffer);
                        if(len == -1) {
                            break;
                        }

                        outputStream.write(buffer,0,len);
                    }
                    outputStream.flush();
                }

            } else {
                OutputStream outputStream = socket.getOutputStream();
                Writer writer = new OutputStreamWriter(outputStream,"UTF-8");
                PrintWriter pw = new PrintWriter(writer);

                //响应行
                pw.printf("HTTP/1.0 404 Not Found\r\n");
                //响应头
                pw.printf("Content-Type: text/html; charset=utf-8\r\n");
                //空行
                pw.printf("\r\n");
                //响应体
                pw.printf("<h1>%s:对应资源不存在</h1>",path);
                pw.flush();
            }



        } catch (IOException exc) {
            exc.printStackTrace(System.out);
        } finally {
            try {
                socket.close();
                System.out.println("一条 TCP 连接已经释放");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
