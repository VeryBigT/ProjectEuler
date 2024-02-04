package problems;

import common.Problem;
import common.util.MathUtil;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Solution for <a href="https://projecteuler.net/problem=37">Problem 37</a>
 * from <a href="https://projecteuler.net/">Project Euler</a>
 */
public class Problem37 extends Problem {
    public static void main(String[] args) {
        new Problem37().run();
    }

    @Override
    protected void solveSimple() {
        primes = MathUtil.allPrimesSmallerThan(10_000);
        System.out.println(isLeftTruncatablePrime(3797));
        System.out.println(isRightTruncatablePrime(3797));
    }

    @Override
    protected void solve() {
        System.out.println(sumOfTruncatablePrimes());
    }

    int[] primes;

    private int sumOfTruncatablePrimes() {
        int limit = 1_000_000;
        primes = MathUtil.allPrimesSmallerThan(limit);
        return IntStream.of(primes)
                .skip(4) //2, 3, 5 and 7 are not considered to be truncatable primes
                .filter(i -> isLeftTruncatablePrime(i) && isRightTruncatablePrime(i))
                //.peek(System.out::println)
                .sum();
    }

    private boolean isRightTruncatablePrime(int i) {
        while(i > 0) {
            if(isNotPrime(i))
                return false;
            i /= 10;
        }
        return true;
    }

    private boolean isLeftTruncatablePrime(int i) {
        int highestDigit = MathUtil.powOfTen((int) Math.log10(i));
        while(i > 0) {
            if(isNotPrime(i))
                return false;
            i -= i / highestDigit * highestDigit;
            highestDigit /= 10;
        }
        return true;
    }

    private boolean isNotPrime(int i) {
        return Arrays.binarySearch(primes, i) < 0;
    }
}