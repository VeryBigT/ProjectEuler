package common.util;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Math {
    public static int pow(int base, int exp) {
        return IntStream.range(0, exp)
                .reduce(1, (a,b) -> a * base);
    }

    public static int powOfTwo(int exp) {
        return 1 << exp;
    }

    public static int powOfTen(int exp) {
        return pow(10, exp);
    }

    public static long pow(long base, long exp) {
        return LongStream.range(0L, exp)
                .reduce(1L, (a,b) -> a * base);
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
