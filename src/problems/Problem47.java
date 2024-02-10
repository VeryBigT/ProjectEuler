package problems;

import common.Problem;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Solution for <a href="https://projecteuler.net/problem=47">Problem 47</a>
 * from <a href="https://projecteuler.net/">Project Euler</a>
 */
public class Problem47 extends Problem {
    public static void main(String[] args) {
        new Problem47().runBoth();
    }

    @Override
    protected void solveSimple() {
        System.out.println(firstOfNNumbersWithNFactors(2));
        System.out.println(firstOfNNumbersWithNFactors(3));
    }

    @Override
    protected void solve() {
        System.out.println(firstOfNNumbersWithNFactors(4));
    }

    static int firstOfNNumbersWithNFactors(int n) {
        int i = 1;
        int[] factors = IntStream.range(n, 2 * n)
                .map(j -> numPrimeFactors(j % n))
                .toArray();
        while(Arrays.stream(factors).anyMatch(j -> j != n)) {
            factors[(++i + n - 1) % n] = numPrimeFactors(i + n - 1);
        }
        return i;
    }

    static int numPrimeFactors(int n) {
        int result = 0;
        int m = 2;
        boolean isNewFactor = true;
        while(n > 1) {
            if(n % m == 0) {
                n /= m;
                if(isNewFactor) {
                    result++;
                    isNewFactor = false;
                }
            }
            else {
                m += m == 2 ? 1 : 2;
                isNewFactor = true;
            }
        }
        return result;
    }
}