package InputSream;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Demo02InputStream {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("E:\\IdeaProjects\\HeimaTest\\IO\\b.txt");

//        byte[] bytes = new byte[4];
//        int len = fis.read(bytes);
//        System.out.println(len);
////        System.out.println(Arrays.toString(bytes));
//        System.out.println(new String(bytes));
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = fis.read(bytes)) != -1) {
            System.out.println(new String(bytes,0,len));
        }



        fis.close();
    }

}
