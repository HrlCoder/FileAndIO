package Reader;

import java.io.FileReader;
import java.io.IOException;

public class Demo01Reader {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("E:\\IdeaProjects\\HeimaTest\\IO\\c.txt");
//        int len = 0;
//        while ((len = fr.read()) != -1) {
//            System.out.println((char) len);
//        }

        char[] ch = new char[1024];
        int len = 0;
        while ((len = fr.read(ch)) != -1) {
            System.out.println(new String(ch,0,len));
        }
        fr.close();
    }
}
