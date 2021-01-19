package Recursion;

/**
 * 递归计算1~n之间的和
 */
public class Demo02Recursion {
    public static void main(String[] args) {
        System.out.println(sum(10));
    }

    private static int sum(int n) {
        if(n == 1) {
            return 1;
        }
        return n+sum(n-1);
    }


}
