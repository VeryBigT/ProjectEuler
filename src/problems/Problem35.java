package problems;

import common.Problem;

import java.util.Arrays;

/**
 * Solution for <a href="https://projecteuler.net/problem=35">Problem 35</a>
 * from <a href="https://projecteuler.net/">Project Euler</a>
 */
public class Problem35 extends Problem {
    public static void main(String[] args) {
        new Problem35().runBoth();
    }

    @Override
    protected void solveSimple() {
        System.out.println(numOfCircularPrimesBelow(100));
    }

    @Override
    protected void solve() {
        System.out.println(numOfCircularPrimesBelow(1_000_000));
    }

    int[] primes;

    private int numOfCircularPrimesBelow(int max) {
        primes = Problem10.allPrimesSmallerThan(max * 10);
        return (int) Arrays.stream(primes)
                .takeWhile(prime -> prime < max)
                .filter(this::isCircularPrime)
                //.peek(System.out::println)
                .count();
    }

    private boolean isCircularPrime(int prime) {
        String numberStr = Integer.toString(prime);
        int log10 = numberStr.length() - 1;
        for (int i = 0; i < log10; i++) {
            numberStr = numberStr.substring(1) + numberStr.charAt(0);
            int n = Integer.parseInt(numberStr);
            if(Arrays.binarySearch(primes, n) < 0)
                return false;
        }
        return true;
    }
}