package problems;

import common.Problem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Solution for <a href="https://projecteuler.net/problem=21">Problem 21</a>
 * from <a href="https://projecteuler.net/">Project Euler</a>
 */
public class Problem21 extends Problem {
    public static void main(String[] args) {
        new Problem21().run();
    }

    @Override
    public void solveSimple() {
    }

    @Override
    public void solve() {
        System.out.println(sumOfAmicableNumbersSmallerThan(10_000));
    }

    private static int sumOfAmicableNumbersSmallerThan(int max) {
        int[] sums = IntStream.range(0, max)
                .map(Problem21::sumOfProperDivisors)
                .toArray();
        List<Integer> amicableNumbers = new ArrayList<>();
        for(int a = 1; a < max; a++) {
            for(int b = 1; b < a; b++) {
                if(a == sums[b] && b == sums[a]) {
                    amicableNumbers.add(a);
                    amicableNumbers.add(b);
                }
            }
        }
        return amicableNumbers.stream().mapToInt(i -> i).sum();
    }

    public static int sumOfProperDivisors(int n) {
        return 1 + IntStream.range(2, (int) Math.sqrt(n) + 1)
                .filter(i -> n % i == 0)
                .map(i -> n/i != i ? i + n/i : i)
                .sum();
    }
}
