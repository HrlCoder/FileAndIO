package PrintStream;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Demo01PrintStream {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream ps = new PrintStream("IO\\print.txt");
        ps.write(97);
        ps.write('a');
        ps.close();
    }
}
