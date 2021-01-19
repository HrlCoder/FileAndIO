package FileTest;

import java.io.File;
import java.util.Arrays;

public class Demo06File {
    public static void main(String[] args) {
        show02();
    }

    private static void show02() {
        File f = new File("E:\\IdeaProjects");
        File[] list = f.listFiles();
        for (File file : list) {
            System.out.println(file);
        }
    }

    private static void show01() {
        File f = new File("E:\\IdeaProjects\\HeimaTest\\File\\src\\FileTest");
        File[] files = f.listFiles();
        for (File file : files) {
            if(file.isDirectory()) {
                System.out.println(file);
            }
        }
//        System.out.println(Arrays.toString(list));
    }

}
