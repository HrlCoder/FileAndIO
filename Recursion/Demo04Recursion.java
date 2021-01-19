package Recursion;

import java.io.File;

/**
 * 递归打印多级目录
 */
public class Demo04Recursion {
    public static void main(String[] args) {
        File file = new File("E:\\IdeaProjects\\HeimaTest\\File");
        getAllFile(file);

    }

    public static void getAllFile(File dir) {
        System.out.println(dir);
        File[] files = dir.listFiles();
        for (File file : files) {
            if(file.isDirectory()) {
                getAllFile(file);
            } else {
                System.out.println(file);
            }
        }
    }

}
