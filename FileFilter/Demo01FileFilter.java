package FileFilter;

import java.io.File;

public class Demo01FileFilter {
    public static void main(String[] args) {
        File file = new File("E:\\IdeaProjects\\HeimaTest\\File");
        getAllFile(file);

    }

    public static void getAllFile(File dir) {
        /**
         * listFIles方法一共做了三件事情：
         *      listFiles方法会对构造方法中传递的目录进行遍历，获取目录中的每一个文件/文件夹-->封装为File对象
         *      listFiles方法会调用参数传递的过滤器中的方法accept
         *      listFiles方法会把遍历得到的每一个File对象，传递给accept的pathname
         *
         *      accept方法返回值是一个布尔值
         *      返回true：就把传递过去的File对象保存到File数组中
         *      返回false：就不会把传递过去的File对象保存到File数组中
         *
         */
        File[] files = dir.listFiles(new FileFilterImpl());//传递过滤器对象

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
