package PrintStream;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Demo02PeintStream {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("控制台");
        PrintStream ps = new PrintStream("IO\\打印流.txt");
        System.setOut(ps);
        System.out.println("我在打印流的目的地中输出");
        ps.close();
    }
}
