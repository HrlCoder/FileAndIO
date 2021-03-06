package v1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//public class HTTPServer {
//    public static void main(String[] args) throws IOException, InterruptedException {
//        ServerSocket serverSocket = new ServerSocket(8080);
//        while (true) {
//            Socket socket = serverSocket.accept();
//
//            Runnable task = new RequestResponseTask(socket);
//            new Thread(task).start();
//        }
//    }
//}

public class HTTPServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket socket = serverSocket.accept();

            Runnable task = new RequestResponseTask(socket);
            threadPool.execute(task);
        }
    }
}