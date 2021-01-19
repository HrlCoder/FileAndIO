package FileTest;

import java.io.File;

public class Demo01File {
    public static void main(String[] args) {
        String pathSeqarator = File.pathSeparator;
        System.out.println(pathSeqarator);//路径分隔符   Windows：；(分号)  Linux: :(冒号)

        String separator = File.separator;
        System.out.println(separator);//文件名称分隔符    Windows：\(反斜杠)  Linux: /(正斜杠)

        //文件路径不能写死，不知道是什么操作系统用File.separator获取文件名称分隔符
        String s = "C:"+File.separator+"develop"+File.separator+"a.txt";
    }
}
