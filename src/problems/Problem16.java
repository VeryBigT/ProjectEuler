package problems;

import common.Problem;

import java.math.BigInteger;

/**
 * Solution for <a href="https://projecteuler.net/problem=16">Problem 16</a>
 * from <a href="https://projecteuler.net/">Project Euler</a>
 */
public class Problem16 extends Problem {
    public static void main(String[] args) {
        new Problem16().run();
    }

    @Override
    public void solveSimple() {
        System.out.println(powerDigitSum(15));
    }

    @Override
    public void solve() {
        System.out.println(powerDigitSum(1000));
    }

    static int powerDigitSum(int i) {
        return BigInteger.TWO.pow(i)
                .toString().chars()
                .map(c -> c - '0')
                .sum();
    }
}
