package problems;

import common.Problem;
import common.util.MathUtil;

import java.util.stream.IntStream;

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
        int[] priems = MathUtil.allPrimesSmallerThan(n);
        return IntStream.of(priems)
                .mapToLong(i -> i)
                .sum();
    }

}
