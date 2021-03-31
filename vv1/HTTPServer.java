package vv1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HTTPServer {
//    public static void main(String[] args) throws IOException {
//        ServerSocket serverSocket = new ServerSocket(8080);
//        while (true) {
//            Socket socket = serverSocket.accept();
//
//            Runnable runnable = new RequestResponseTask(socket);
//            new Thread(runnable).start();
//        }
//    }

    public static void main(String[] args) throws IOException {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket socket = serverSocket.accept();

            Runnable runnable = new RequestResponseTask(socket);
            new Thread(runnable).start();
        }
    }
}
