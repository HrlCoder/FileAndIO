package 属性集;

import java.io.*;
import java.util.Properties;
import java.util.Set;

/*
    java.util.Properties集合 extends Hashtable<k,v> implements Map<k,v>
    Properties 类表示一个持久的属性集。Properties 可保存在流中或从流中加载
    Properties 集合是一个唯一和IO流相结合的集合
        可以使用Properties集合中的方法store，吧集合中的临时数据，持久化写入到硬盘中存储
        可以使用Properties集合中的方法load，把硬盘中保存的文件（键值对），读取到集合中使用

    属性列表中每个键及其对应值都是一个字符串
        Properties 集合是一个双列集合。 key 和 value 默认都是字符串
 */
public class Demo01Properties {

    //public Object setProperty(String key, String value)： 保存一对属性。
    //public String getProperty(String key) ：使用此属性列表中指定的键搜索属性值。
    //public Set<String> stringPropertyNames() ：所有键的名称的集合。
    public static void main(String[] args) throws IOException {
        show03();
    }

    private static void show03() throws IOException {
        Properties prop = new Properties();
        prop.load(new FileReader("E:\\IdeaProjects\\HeimaTest\\IO\\prop.txt"));
        Set<String> set = prop.stringPropertyNames();
        for (String s : set) {
            String property = prop.getProperty(s);
            System.out.println(property);
        }
    }

    private static void show02() throws IOException {
        Properties prop = new Properties();
        prop.setProperty("中中","168");
        prop.setProperty("小学","161");
        prop.setProperty("英语","165");


        /*
        字符流可以写中文，字节流不可以写中文
         */
        FileWriter fw = new FileWriter("E:\\IdeaProjects\\HeimaTest\\IO\\prop.txt");
        prop.store(fw,"save data");
        fw.close();

        prop.store(new FileOutputStream("E:\\IdeaProjects\\HeimaTest\\IO\\prop2.txt"),"");

    }

    private static void show01() {
        Properties prop = new Properties();
        //使用setProperty往集合中添加数据
        prop.setProperty("中中","168");
        prop.setProperty("小学","161");
        prop.setProperty("英语","165");

        //使用StringPropertyNames把setProperties集合中的键取出，存储到一个set集合中
        Set<String> set = prop.stringPropertyNames();
        //取出每一个键
        for (String key : set) {
            String property = prop.getProperty(key);
            System.out.println(property);
        }
    }
}
