package Reader;

import java.io.FileInputStream;
import java.io.IOException;

public class InputStream {
    public static void main(String[] args) throws IOException {

        //乱码
        FileInputStream fis = new FileInputStream("E:\\IdeaProjects\\HeimaTest\\IO\\c.txt");
        int len = 0;
        while ((len = fis.read()) != -1) {
            //字节流读取中文会产生乱码
            System.out.println((char) len);
        }
        fis.close();


    }
}
