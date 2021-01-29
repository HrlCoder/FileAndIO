package InputSream;

import java.io.FileInputStream;
import java.io.IOException;

/*
    java.io.InputStream：字节输入流
    此抽象类是表示字节输入流的所有类的超类
    定义了所有子类共性的方法：
        public void close() ：关闭此输入流并释放与此流相关联的任何系统资源。
        public abstract int read()： 从输入流读取数据的下一个字节。
        public int read(byte[] b)： 从输入流中读取一些字节数，并将它们存储到字节数组 b中 。

    java.io.FileInputStream extends InputStream
    FileInputStream 文件字节输入流，从文件中读取字节。
    作用：把硬盘文件中的数据，读取到内存中使用

    构造方法：
    FileInputStream(File file)
    FileInputStream(String name)
    参数：读取文件的数据源
        String name：文件的路径
        File file：文件
    构造方法的作用：
        1.会创建一个FileInputStream对象
        2.会把FileInputStream对象指定构造方法中要读取的文件

    读取数据的原理：(硬盘-->内存)
        java程序--JVM--OS==OS读取数据的方法--读取文件

    字节输入流的使用步骤：
        1.创建FileInputStream对象，构造方法中绑定要读取的数据源
        2.使用FileInputStream对象中的方法read读取文件
        3，释放资源
 */
public class Demo01InputStream {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("E:\\IdeaProjects\\HeimaTest\\IO\\a.txt");
//        System.out.println(fis.read());//97
//        System.out.println(fis.read());//-1

        //重点是这个循环的书写
        int len = 0;
        while ((len = fis.read())!= -1) {
            System.out.print ((char)len);
        }

        fis.close();
    }

}
