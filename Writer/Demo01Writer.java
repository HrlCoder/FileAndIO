package Writer;

import java.io.FileWriter;
import java.io.IOException;

public class Demo01Writer {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("E:\\IdeaProjects\\HeimaTest\\IO\\d.txt");
        //字符转换为字节，写到内存缓冲区中
        fw.write(97);
        //把内存缓冲区的文件，刷新到文件中，流还可以使用
//        fw.flush();

        //关闭之前，也会刷新到文件中去，流就不能再使用了
        fw.close();
    }
}
