package FileTest;

import java.io.File;

/**
 * 路径：
 * 绝对路径:完整路径
 *          C:\\a.txt
 *          D:\\demo\\b.txt
 * 相对路径：简化路径
 *          相对于当前项目的根目录D:\\demo\\b.txt
 *          如果使用当前项目的根目录，路径可以简化书写
 *          D:\\demo\\b.txt--->b.txt(可以省略项目的根目录)
 * 注意：
 *          路径不区分大小写
 *          路径中的文件名分隔符Windows使用反斜杠，反斜杠是转义字符，两个反斜杠代表一个普通的反斜杠
 */
public class Demo02File {
    public static void main(String[] args) {
        /**
         * File类的构造方法
         */
//        show01();
//        show02("c:\\","a.txt");
        show03();
    }

    private static void show03() {
        //可以使用File类的方法对路径进行一些操作，再使用路径创建对象
        File parent = new File("c:\\");
        File file = new File(parent,"hello.java");
        System.out.println(file);
    }

    private static void show02(String parent,String child) {
        File file = new File(parent,child);
        System.out.println(file);
    }

    private static void show01() {
        File file =  new File("E:\\IdeaProjects\\HeimaTest\\File\\src\\FileTest\\file.txt");
        System.out.println(file);//只是打印该路径，表示重写了Object类的toString方法

        File file1 =  new File("E:\\IdeaProjects\\HeimaTest\\File\\src\\FileTest");
        System.out.println(file1);

        File file2 =  new File("file.txt");
        System.out.println(file2);
    }
}
