package Recursion;

/**
 * 递归求阶乘
 */
public class Demo03Recursion {
    public static void main(String[] args) {
        System.out.println(mul(6));
    }

    private static int mul(int n) {
        if(n == 1) {
            return 1;
        }
        return n*mul(n-1);
    }


}
