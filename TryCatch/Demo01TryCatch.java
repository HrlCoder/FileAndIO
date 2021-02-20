package TryCatch;

import java.io.FileWriter;
import java.io.IOException;

public class Demo01TryCatch {
    public static void main(String[] args) {
        FileWriter fw = null;
        try {
            fw = new FileWriter("E:\\IdeaProjects\\HeimaTest\\IO\\f.txt",true);
            for (int i = 0; i < 10; i++) {
                fw.write("helloworld"+i+"\r\n");
            }
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            if(fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
