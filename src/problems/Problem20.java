package problems;

import common.Problem;

import java.math.BigInteger;

/**
 * Solution for <a href="https://projecteuler.net/problem=20">Problem 20</a>
 * from <a href="https://projecteuler.net/">Project Euler</a>
 */
public class Problem20 extends Problem {
    public static void main(String[] args) {
        new Problem20().run();
    }

    @Override
    public void solveSimple() {
        System.out.println(factorialDigitSum(10));
    }

    @Override
    public void solve() {
        System.out.println(factorialDigitSum(100));
    }

    static int factorialDigitSum(int base) {
        BigInteger z = BigInteger.ONE;
        for(int i = 2; i <= base; i++) {
            z = z.multiply(BigInteger.valueOf(i));
            while(z.mod(BigInteger.TEN).equals(BigInteger.ZERO))
                z = z.divide(BigInteger.TEN);
        }
        return z.toString().chars()
                .map(c -> c - '0')
                .sum();
    }
}
