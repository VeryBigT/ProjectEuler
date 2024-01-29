package problems;

import common.Problem;

import java.util.List;
import java.util.stream.IntStream;

/**
 * Solution for <a href="https://projecteuler.net/problem=23">Problem 23</a>
 * from <a href="https://projecteuler.net/">Project Euler</a>
 */
public class Problem23 extends Problem {
    public static void main(String[] args) {
        new Problem23().run();
    }

    @Override
    public void solveSimple() {
    }

    @Override
    public void solve() {
        System.out.println(sumOfAllNonAbundantSums());
    }

    static final int abundantSumsLimit = 28_123;

    private static int sumOfAllNonAbundantSums() {
        List<Integer> abundantNumbers = allAbundantNumbersSmallerThan(abundantSumsLimit - 11);
        return IntStream.range(1, abundantSumsLimit)
                .parallel()
                .filter(i -> isNotSumOf(i, abundantNumbers))
                .sum();
    }

    private static List<Integer> allAbundantNumbersSmallerThan(int n) {
        return IntStream.range(1, n)
                .parallel()
                .filter(i -> Problem21.sumOfProperDivisors(i) > i)
                .boxed().toList();
    }

    private static boolean isNotSumOf(int sum, List<Integer> abundantNumbers) {
        return abundantNumbers.stream()
                .takeWhile(i -> sum >= i + 12)
                .noneMatch(an -> abundantNumbers.contains(sum - an));
    }
}
