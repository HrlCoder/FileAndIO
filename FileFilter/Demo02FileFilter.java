package FileFilter;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class Demo02FileFilter {
    public static void main(String[] args) {
        File file = new File("E:\\IdeaProjects\\HeimaTest\\File");
        getAllFile(file);

    }

    public static void getAllFile(File dir) {

        //匿名内部类
//        File[] files = dir.listFiles(new FileFilter() {
//            @Override
//            public boolean accept(File pathname) {
//                //过滤规则
//                return pathname.isDirectory() || pathname.getName().toLowerCase().endsWith(".java");
//            }
//        });//传递过滤器对象

//            File[] files = dir.listFiles((File pathname)->pathname.isDirectory() || pathname.getName().toLowerCase().endsWith(".java"));//传递过滤器对象

//        File[] files = dir.listFiles(new FilenameFilter() {
//            @Override
//            public boolean accept(File pathname,String name) {
//                return new File(dir,name).isDirectory() || name.toLowerCase().endsWith(".java");
//            }
//        });

        File[] files = dir.listFiles((File pathname,String name)->new File(dir,name).isDirectory() || name.toLowerCase().endsWith(".java"));

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
