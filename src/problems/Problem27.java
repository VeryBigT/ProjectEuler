package problems;

import common.Problem;
import common.util.MathUtil;

import java.util.Arrays;

/**
 * Solution for <a href="https://projecteuler.net/problem=27">Problem 27</a>
 * from <a href="https://projecteuler.net/">Project Euler</a>
 */
public class Problem27 extends Problem {
    public static void main(String[] args) {
        new Problem27().run();
    }

    @Override
    protected void solveSimple() {
        int[] primes = MathUtil.allPrimesSmallerThan(2_000);
        System.out.println(numberOfPrimes(primes, 1, 41));
        System.out.println(numberOfPrimes(primes, -79, 1601));
    }

    @Override
    protected void solve() {
        System.out.println(maxCoefficientProductOfQuadraticPrimes());
    }

    static int maxCoefficientProductOfQuadraticPrimes() {
        int[] primes = MathUtil.allPrimesSmallerThan(2_000);
        int maxN = 0, maxA = 0, maxB = 0;
        for(int a = -999; a < 1000; a += 2) {
            for(int b : primes) {
                if(b >= 1000)
                    break;
                int n = numberOfPrimes(primes, a, b);
                if(n > maxN) {
                    maxN = n;
                    maxA = a;
                    maxB = b;
                }
            }
        }
        return maxA * maxB;
    }

    static int numberOfPrimes(int[] primes, int a, int b) {
        int n = 0, z;
        do {
            n++;
            z = n * n + a * n + b;
        } while(Arrays.binarySearch(primes, z) > 0);
        return n;
    }
}