package problems;

import common.Problem;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/**
 * Solution for <a href="https://projecteuler.net/problem=29">Problem 29</a>
 * from <a href="https://projecteuler.net/">Project Euler</a>
 */
public class Problem29 extends Problem {
    public static void main(String[] args) {
        new Problem29().runBoth();
    }

    @Override
    protected void solveSimple() {
        System.out.println(distinctPowers(5, 5));
    }

    @Override
    protected void solve() {
        System.out.println(distinctPowers(100, 100));
    }

    private static int distinctPowers(int maxBase, int maxExp) {
        Set<BigInteger> distinctPowers = new HashSet<>();
        for(int base = 2; base <= maxBase; base++)
            for(int exp = 2; exp <= maxExp; exp++)
                distinctPowers.add(BigInteger.valueOf(base).pow(exp));
        return distinctPowers.size();
    }
}