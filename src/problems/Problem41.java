package problems;

import common.Problem;
import common.util.MathUtil;

import java.util.Collections;
import java.util.stream.IntStream;

/**
 * Solution for <a href="https://projecteuler.net/problem=41">Problem 41</a>
 * from <a href="https://projecteuler.net/">Project Euler</a>
 */
public class Problem41 extends Problem {
    public static void main(String[] args) {
        new Problem41().run();
    }

    @Override
    protected void solveSimple() {
    }

    @Override
    protected void solve() {
        System.out.println(largestPandigitalPrime());
    }

    static final int[] masks = {0b1, 0b11, 0b111, 0b1_111, 0b11_111,
            0b111_111, 0b1_111_111, 0b11_111_111, 0b111_111_111};

    private static int largestPandigitalPrime() {
        int[] primes = MathUtil.allPrimesSmallerThan(87_654_322);
        for(int i = primes.length - 1; ;i--) {
            if(isPandigital(primes[i]))
                return primes[i];
        }
        /*return IntStream.of(primes)
                .filter(Problem41::isPandigital)
                .max().orElse(-1);*/
        /*return IntStream.of(primes)
                .boxed()
                .sorted(Collections.reverseOrder())
                .filter(Problem41::isPandigital)
                .findFirst().orElse(-1);*/
    }

    private static boolean isPandigital(Integer n) {
        int digitMask = 0;
        int numberSize = (int) Math.log10(n);
        while(n > 0) {
            int digit = n % 10;
            digitMask |= digit == 0 ? 0 : 1 << (digit - 1);
            n /= 10;
        }
        return digitMask == masks[numberSize];
    }
}