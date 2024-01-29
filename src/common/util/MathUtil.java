package common.util;

public class MathUtil {
    public static int pow(int base, int exp) {
        int result = 1;
        while(exp-- > 0)
            result *= base;
        return result;
    }

    public static int powOfTwo(int exp) {
        return 1 << exp;
    }

    public static int powOfTen(int exp) {
        return pow(10, exp);
    }

    public static long pow(long base, long exp) {
        long result = 1L;
        while(exp-- > 0L)
            result *= base;
        return result;
    }

    public static long powOfTwo(long exp) {
        return 1L << exp;
    }

    public static long powOfTen(long exp) {
        return pow(10L, exp);
    }

    public static void main(String[] args) {
        System.out.println(pow(2, 3));
        System.out.println(pow(3, 2));
        System.out.println(pow(4, 1));
        System.out.println(pow(5, 0));
    }
}
