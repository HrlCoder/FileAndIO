package ReverseStream;

import java.io.*;

public class Demo04Test {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(
                new FileInputStream("IO\\GBKzzzzz.txt"),"GBK");
        OutputStreamWriter osw = new OutputStreamWriter(
                new FileOutputStream("IO\\UTF_8zzzzz.txt"),"UTF-8");
        int len = 0;
        while ((len = isr.read()) != -1) {
            osw.write(len);
        }
        osw.close();
        isr.close();
    }
}
