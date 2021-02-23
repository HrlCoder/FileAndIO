package BufferedWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Demo01BufferedWriter {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\IdeaProjects\\HeimaTest\\IO\\c.txt"));
        for (int i = 0; i < 10; i++) {
            bw.write("在干嘛");
            bw.newLine();
//            bw.write("\r\n");
        }
        bw.flush();
        bw.close();
    }
}
