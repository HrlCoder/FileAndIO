package FileTest;

import java.io.File;

public class Demo03File {
    public static void main(String[] args) {
        show04();
    }

    private static void show04() {
        File file1 = new File("E:\\IdeaProjects\\HeimaTest\\File\\src\\FileTest\\a.txt");
        long l1 = file1.length();
        System.out.println(l1);

        File file2 = new File("E:\\IdeaProjects\\HeimaTest\\File\\src\\FileTest\\Demo01File.java");
        long l2 = file1.length();
        System.out.println(l2);
    }

    private static void show03() {
        File file1 = new File("E:\\IdeaProjects\\HeimaTest\\File\\src\\FileTest\\a.txt");
        String name1 = file1.getName();
        System.out.println(name1);

        File file2 = new File("a.txt");
        String name2 = file2.getName();
        System.out.println(name2);
    }

    private static void show02() {
        File file1 = new File("E:\\IdeaProjects\\HeimaTest\\File\\src\\FileTest\\a.txt");
        String Path1 = file1.getPath();
        System.out.println(Path1);

        File file2 = new File("a.txt");
        String Path2 = file2.getPath();
        System.out.println(Path2);
    }

    private static void show01() {
        File file1 = new File("E:\\IdeaProjects\\HeimaTest\\File\\src\\FileTest\\a.txt");
        String absolutePath1 = file1.getAbsolutePath();
        System.out.println(absolutePath1);

        File file2 = new File("a.txt");
        String absolutePath2 = file2.getAbsolutePath();
        System.out.println(absolutePath2);
    }
}
