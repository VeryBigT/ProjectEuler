package problems;

import common.Problem;
import common.util.MathUtil;

import java.util.Arrays;

/**
 * Solution for <a href="https://projecteuler.net/problem=51">Problem 51</a>
 * from <a href="https://projecteuler.net/">Project Euler</a>
 */
public class Problem51 extends Problem {
    public static void main(String[] args) {
        new Problem51().run();
    }

    @Override
    protected void solveSimple() {

    }

    @Override
    protected void solve() {
        final int[] primes = MathUtil.allPrimesSmallerThan(1_000_000_000);
        int result = Arrays.stream(primes).parallel()
                .filter(prime -> primeFamilySize(prime, primes) == 8)
                .findFirst().orElse(-1);
        System.out.println(result);
    }

    private int primeFamilySize(int prime, int[] primes) {
        //int[] digits = MathUtil.digitsArray(prime);
        //int length = digits.length;
        return 0;
    }


}