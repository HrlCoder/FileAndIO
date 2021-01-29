package 文件复制;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("E:\\IdeaProjects\\HeimaTest\\IO\\a.txt");
        FileOutputStream fos = new FileOutputStream("E:\\IdeaProjects\\HeimaTest\\IO\\d.txt");
//        int len = 0;
//        while ((len = fis.read()) != -1) {
//            fos.write(len);
//        }

        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = fis.read(bytes)) != -1) {
            fos.write(bytes,0,len);
        }


        fos.close();
        fis.close();
    }
}
