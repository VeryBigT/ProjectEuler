package common.util;

import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

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

    public static int[] allPrimesSmallerThan(int n) {
        if(n == 2)
            return new int[]{2};
        if(n < 2)
            return new int[]{};
        if(2L * (n-1) + 3 > (long)Integer.MAX_VALUE)
            throw new IllegalArgumentException("n is to big!");
        boolean[] isNotPrime = new boolean[n / 2 - 1];
        int crossLimit = (int) Math.sqrt(n);
        for(int i = 0; i < crossLimit; i++) {
            if(isNotPrime[i])
                continue;
            int p = (i * 2) + 3;
            for(int j = p * p; j < n; j += p) {
                if(j % 2 != 0)
                    isNotPrime[(j - 3) / 2] = true;
            }
        }
        return Stream.concat(IntStream.of(2).boxed(),
                IntStream.range(0, isNotPrime.length)
                        .filter(i -> !isNotPrime[i])
                        .map(i -> 2 * i + 3).boxed())
                .mapToInt(i -> i)
                .toArray();
    }

    public static long[] allPrimesSmallerThan(long n) {
        if(n < 2)
            return new long[]{};
        if(n == 2)
            return new long[]{2};
        if(n == 3)
            return new long[]{2, 3};
        if(n / 2 - 1 > (long)Integer.MAX_VALUE)
            throw new IllegalArgumentException("n is to big!");
        boolean[] isNotPrime = new boolean[(int) (n / 2 - 1)];
        int crossLimit = (int) Math.sqrt(n);
        for(int i = 0; i < crossLimit; i++) {
            if(isNotPrime[i])
                continue;
            int p = (i * 2) + 3;
            for(int j = p * p; j < n; j += p) {
                if(j % 2 != 0)
                    isNotPrime[(j - 3) / 2] = true;
            }
        }
        return Stream.concat(LongStream.of(2).boxed(),
                IntStream.range(0, isNotPrime.length)
                        .filter(i -> !isNotPrime[i])
                        .mapToLong(i -> 2L * i + 3).boxed())
                .mapToLong(i -> i)
                .toArray();
    }
}
