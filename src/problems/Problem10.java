package problems;

import common.Problem;

import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Solution for <a href="https://projecteuler.net/problem=10">Problem 10</a>
 * from <a href="https://projecteuler.net/">Project Euler</a>
 */
public class Problem10 extends Problem {
    public static void main(String[] args) {
        new Problem10().run();
    }

    @Override
    protected void solveSimple() {
        System.out.println(sumOfPrimesSmallerThan(10));
    }

    @Override
    protected void solve() {
        System.out.println(sumOfPrimesSmallerThan(2_000_000));
    }

    static long sumOfPrimesSmallerThan(int n) {
        int[] priems = allPrimesSmallerThan(n);
        return IntStream.of(priems)
                .mapToLong(i -> i)
                .sum();
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
