package Writer;

import java.io.FileWriter;
import java.io.IOException;

public class Demo02Writer {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("E:\\IdeaProjects\\HeimaTest\\IO\\e.txt");
        char[] cs = {'a','b','c','d','e'};
        fw.write(cs);

        fw.write(cs,1,3);
        fw.write("传智播客");
        fw.write("传智播客",2,2);
        fw.close();
    }
}
