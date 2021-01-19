package Recursion;

public class Demo01Recursion {
    public static void main(String[] args) {
//        a();//栈溢出   java.lang.StackOverflowError
        b(1);
    }

    /**
     * 构造方法禁止递归
     *      编译报错：构造方法是创建对象使用的，一直递归调用会导致内存中有无数多个对象，直接编译错误
     */
//    public DemoRecursion() {
//        DemoRecursion();
//    }

    /**
     * 虽然有条件限制，但次数太多也会导致栈溢出
     */
    private static void b(int i) {
        System.out.println(i);
        if(i == 20000) {
            return;
        }
        b(++i);

    }

    /**
     * 没有条件限定会导致栈溢出
     */

    private static void a() {
        System.out.println("a方法");
        a();
    }
}
