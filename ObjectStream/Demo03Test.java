package ObjectStream;

import java.io.*;
import java.util.ArrayList;

public class Demo03Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("哈哈",11));
        list.add(new Person("嘿嘿",12));
        list.add(new Person("呵呵",13));
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("IO\\list.txt"));
        oos.writeObject(list);
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("IO\\list.txt"));
        Object o = ois.readObject();
        System.out.println(o);
        ArrayList<Person> list2 = (ArrayList<Person>)o;
        for (Person person : list) {
            System.out.println(person);
        }
        ois.close();
        oos.close();

    }
}
