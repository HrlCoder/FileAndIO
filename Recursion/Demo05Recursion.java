package Recursion;

import java.io.File;

/**
 * 递归打印多级目录，只打印.java后缀的文件
 */
public class Demo05Recursion {
    public static void main(String[] args) {
        File file = new File("E:\\IdeaProjects\\HeimaTest\\File");
        getAllFile(file);

    }

    public static void getAllFile(File dir) {
//        System.out.println(dir);//打印目录
        File[] files = dir.listFiles();
        for (File file : files) {
            if(file.isDirectory()) {
                getAllFile(file);
            } else {
//                String name = file.getName();
//                String path = file.getPath();

//                String s = file.toString();
//                s = s.toLowerCase();//大写变小写
//                boolean b = s.endsWith(".java");
//                if(b) {
//                    System.out.println(file);
//                }

                if(file.getName().toLowerCase().endsWith(".java")) {
                    System.out.println(file);
                }
            }
        }
    }

}
