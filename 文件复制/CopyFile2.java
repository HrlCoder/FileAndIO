package 文件复制;

import java.io.*;

public class CopyFile2 {
    public static void main(String[] args) throws IOException {
        long s = System.currentTimeMillis();

        BufferedInputStream bis = new BufferedInputStream(
                new FileInputStream("E:\\IdeaProjects\\HeimaTest\\IO\\a.txt"));
        BufferedOutputStream bos = new BufferedOutputStream(
                new FileOutputStream("E:\\IdeaProjects\\HeimaTest\\IO\\c.txt"));
//        int len = 0;
//        while ((len = bis.read()) != -1) {
//            bos.write(len);
//        }
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes,0,len);
        }
        bos.close();
        bis.close();

        long e = System.currentTimeMillis();
        System.out.println("复制文件共耗时："+(e-s)+"毫秒");
    }
}
