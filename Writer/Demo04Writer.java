package Writer;

import java.io.FileWriter;
import java.io.IOException;

public class Demo04Writer {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("E:\\IdeaProjects\\HeimaTest\\IO\\f.txt",true);
        for (int i = 0; i < 10; i++) {
            fw.write("helloworld"+i+"\r\n");
        }
        fw.close();
    }
}
