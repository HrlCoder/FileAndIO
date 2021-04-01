package vv3;

import java.io.*;

public class SerializableDemo  {
    /**
     * 写数据
     * @param args
     * @throws IOException
     * @throws ClassNotFoundException
     */
//    public static void main(String[] args) throws IOException {
//        User u1 = new User(1,"ll","男");
//        User u2 = new User(2,"jj","女");
//
//        String filename = "E:\\IdeaProjects\\比特-code\\HTTP\\sessions\\username.obj";
//        try(OutputStream os = new FileOutputStream(filename)) {
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(os);
//
//            objectOutputStream.writeObject(u1);
//            objectOutputStream.writeObject(u2);
//
//            objectOutputStream.flush();
//        }
//    }

    /**
     * 读数据
     * @param args
     * @throws IOException
     * @throws ClassNotFoundException
     */

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String filename = "E:\\IdeaProjects\\比特-code\\HTTP\\sessions\\username.obj";

        try(InputStream is = new FileInputStream(filename)) {
            ObjectInputStream objectInputStream = new ObjectInputStream(is);

            User u1 = (User) objectInputStream.readObject();
            User u2 = (User) objectInputStream.readObject();

            System.out.println(u1);
            System.out.println(u2);
        }
    }

}
