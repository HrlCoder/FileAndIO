package OutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/*

 */
public class Demo1OutputStream {
    public static void main(String[] args) throws IOException {
        //1.创建一个FileOutputStream对象，构造方法中传递写入数据的目的地
        FileOutputStream fos = new FileOutputStream(new File("E:\\IdeaProjects\\HeimaTest\\IO\\b.txt"));
        //2.调用FileOutputStream对象中的方法write，把数据写入到文件中
        //显示100
        fos.write(49);
        fos.write(48);
        fos.write(48);

        /*
            void write​(byte[] b) 将 b.length字节从指定的字节数组写入此输出流。
            一次写入多个字节：
            如果第一个字节是正数（0-127），显示的时候会查询ASCII
            如果第一个字节是负数，第一个字节和第二个字节，两个字节组成一个中文显示，查询系统默认码表（GBK）
         */
        byte[] bytes = {65,66,67,68,69};
        byte[] bytes2 = {-65,-66,-67,-68,69};
        fos.write(bytes);
        fos.write(bytes2);

        /*
            void write​(byte[] b, int off, int len) 从指定的字节数组写入 len字节，从偏移量 off开始输出到此输出流。
            把字节数组的一部分写入到文件中
            从指定的字节数组写入len字节，从偏移量off开始输出到此输出流
              int off:数组的开始索引
              int len：写字节的数量
         */
        fos.write(bytes,1,2);

        /*
            写入字符串的方法：可以使用String类中的方法把字符串转换为数组
            byte[] getBytes​() 使用平台的默认字符集将该 String编码为一系列字节，将结果存储到新的字节数组中。
            作用：byte[] getBytes​()把字符串转换为字节数组
         */
        byte[] bytes3 = "干嘛".getBytes("GBK");
        System.out.println(Arrays.toString(bytes3));//[-27, -71, -78, -27, -104, -101]
        fos.write(bytes3);

        //3.释放资源
        fos.close();
    }
}
