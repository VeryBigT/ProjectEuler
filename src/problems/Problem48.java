package problems;

import common.Problem;

import java.math.BigInteger;
import java.util.stream.IntStream;

/**
 * Solution for <a href="https://projecteuler.net/problem=48">Problem 48</a>
 * from <a href="https://projecteuler.net/">Project Euler</a>
 */
public class Problem48 extends Problem {
    public static void main(String[] args) {
        new Problem48().run();
    }

    @Override
    protected void solveSimple() {
    }

    @Override
    protected void solve() {
        String result = IntStream.rangeClosed(1, 1_000)
                .mapToObj(i -> BigInteger.valueOf(i).pow(i))
                .reduce(BigInteger.ZERO, BigInteger::add)
                .toString();
        System.out.println(result.substring(result.length() - 10));
    }
}