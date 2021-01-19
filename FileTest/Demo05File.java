package FileTest;

import java.io.File;
import java.io.IOException;

public class Demo05File {
    public static void main(String[] args) throws IOException {
        show01();
    }

    private static void show02() throws IOException {
        File f = new File("E:\\IdeaProjects\\HeimaTest\\File\\src\\FileTest1");
        System.out.println(f.exists());
        System.out.println(f.mkdir());
        System.out.println(f.exists());
    }

    private static void show01() throws IOException {
        File f = new File("E:\\IdeaProjects\\HeimaTest\\File\\src\\FileTest\\aaa.txt");
        System.out.println(f.exists());
//        System.out.println(f.createNewFile());
        System.out.println(f.delete());
        System.out.println(f.exists());
    }
}
