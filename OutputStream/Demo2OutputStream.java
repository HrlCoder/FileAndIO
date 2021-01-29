package OutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/*
    追加写/续写：使用两个参数的构造方法
       FileOutputStream(File file, boolean append)`： 创建文件输出流以写入由指定的 File对象表示的文件。
       FileOutputStream(String name, boolean append)`： 创建文件输出流以指定的名称写入文件。
       参数：
        String name, File file:写入数据的目的地
        boolean append:追加写开关
            true：创建对象不会覆盖原文件，继续在文件的末尾追加写数据
            false：创建一个新文件，覆盖原文件

     写换行：写换行符号
        Windows：\r\n
        linux:\n
        max:\r
 */

public class Demo2OutputStream {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("E:\\IdeaProjects\\HeimaTest\\IO\\c.txt",true);
        for (int i = 0; i < 10; i++) {
            fos.write("你好".getBytes());
            fos.write("\r\n".getBytes());
        }
        fos.close();

    }
}
