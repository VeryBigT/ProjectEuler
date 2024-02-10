package problems;

import common.Problem;
import common.util.MathUtil;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Solution for <a href="https://projecteuler.net/problem=46">Problem 46</a>
 * from <a href="https://projecteuler.net/">Project Euler</a>
 */
public class Problem46 extends Problem {
    public static void main(String[] args) {
        new Problem46().run();
    }

    @Override
    protected void solveSimple() {
    }

    @Override
    protected void solve() {
        System.out.println(disproveGoldbachsOtherConjecture());
    }

    private static int disproveGoldbachsOtherConjecture() {
        int[] primes = MathUtil.allPrimesSmallerThan(10_000);
        return IntStream.iterate(9, i -> i + 2)
                .filter(i -> Arrays.binarySearch(primes, i) < 0)
                .filter(i -> disprovesConjecture(i, primes))
                .findFirst().orElse(-1);
    }

    private static boolean disprovesConjecture(int n, int[] primes) {
        return Arrays.stream(primes)
                .takeWhile(p -> p < n)
                .map(p -> (n - p) / 2)
                .noneMatch(i -> {
                    double sqrt = Math.sqrt(i);
                    return sqrt == (int) sqrt;
                });
    }
}