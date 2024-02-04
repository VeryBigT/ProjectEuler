package problems;

import common.Problem;
import static common.util.MathUtil.*;

import java.util.stream.IntStream;
import static java.lang.Math.*;

/**
 * Solution for <a href="https://projecteuler.net/problem=36">Problem 36</a>
 * from <a href="https://projecteuler.net/">Project Euler</a>
 */
public class Problem36 extends Problem {
    public static void main(String[] args) {
        new Problem36().run();
    }

    @Override
    protected void solveSimple() {
        System.out.println(isPalindromeInBase(585, 2));
        System.out.println(isPalindromeInBase(585, 8));
        System.out.println(isPalindromeInBase(585, 10));
        System.out.println(isPalindromeInBase(585, 16));
    }

    @Override
    protected void solve() {
        System.out.println(sumOfAllPalindromesInBases(2, 10));
    }

    private int sumOfAllPalindromesInBases(int... bases) {
        return IntStream.range(1, 1_000_000)
                .filter(i -> IntStream.of(bases)
                        .allMatch(b -> isPalindromeInBase(i, b)))
                //.peek(System.out::println)
                .sum();
    }

    //lazy solution (~ 3 times slower)
    private boolean isPalindromeInBaseLazy(int i, int base) {
        String str = Integer.toString(i, base);
        return str.equals(new StringBuilder(str).reverse().toString());
    }

    private boolean isPalindromeInBase(int i, int base) {
        int left = pow(base, (int) (log(i) / log(base)));
        int base2 = base * base;
        while(i > 0) {
            int leftDigit = i / left;
            int rightDigit = i % base;
            if(leftDigit != rightDigit)
                return false;
            i -= left * leftDigit;
            i /= base;
            left /= base2;
        }
        return true;
    }
}