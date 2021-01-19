package FileTest;

import java.io.File;

public class Demo04File {
    public static void main(String[] args) {
        show03();
    }

    private static void show03() {
        File file1 = new File("E:\\IdeaProjects\\HeimaTest\\File\\src\\FileTest");
        boolean b = file1.isFile();
        System.out.println(b);

        File file2 = new File("E:\\IdeaProjects\\HeimaTest\\File\\src\\FileTest\\Demo01File.java");
        boolean c = file2.isFile();
        System.out.println(c);
    }

    private static void show02() {
        File file1 = new File("E:\\IdeaProjects\\HeimaTest\\File\\src\\FileTest");
        boolean b = file1.isDirectory();
        System.out.println(b);

        File file2 = new File("E:\\IdeaProjects\\HeimaTest\\File\\src\\FileTest\\a.txt");
        boolean c = file2.isDirectory();
        System.out.println(c);
    }

    private static void show01() {
        File file1 = new File("E:\\IdeaProjects\\HeimaTest\\File\\src\\FileTest");
        boolean b = file1.exists();
        System.out.println(b);

        File file2 = new File("E:\\IdeaProjects\\HeimaTest\\File\\src\\FileTest\\a.txt");
        boolean c = file2.exists();
        System.out.println(c);
    }
}
