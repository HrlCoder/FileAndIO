package ReverseStream;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/*
    InputStreamReader(InputStream in): 创建一个使用默认字符集的字符流。
    InputStreamReader(InputStream in, String charsetName): 创建一个指定字符集的字符流。
 */
public class Demo02OutputStreamWriter {
    public static void main(String[] args) throws IOException {
        write_utf_8();
//        write_gbk_8();
    }

    /**
     * 使用转换流OutputStreamWriter写gbk格式文件
     */
    private static void write_gbk_8() throws IOException {
        OutputStreamWriter osw = new OutputStreamWriter(
                new FileOutputStream("IO\\gbk.txt"),"GBK");
        osw.write("你好");
        osw.flush();
        osw.close();
    }

    /**
     * 使用转换流OutputStreamWriter写UTF-8格式文件
     */
    private static void write_utf_8() throws IOException {
        OutputStreamWriter osw = new OutputStreamWriter(
                new FileOutputStream("IO\\utf_8.txt"),"utf-8");
        osw.write("你好");
        osw.flush();
        osw.close();
    }
}
