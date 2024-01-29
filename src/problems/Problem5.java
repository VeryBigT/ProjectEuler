package problems;

import common.Problem;

import static java.lang.Math.*;

/**
 * Solution for <a href="https://projecteuler.net/problem=5">Problem 5</a>
 * from <a href="https://projecteuler.net/">Project Euler</a>
 */
public class Problem5 extends Problem {
    public static void main(String[] args) {
        new Problem5().run();
    }

    @Override
    protected void solveSimple() {
        System.out.println(smallestNumberDivisibleTill(10));
    }

    @Override
    protected void solve() {
        System.out.println(smallestNumberDivisibleTill(20));
    }

    static long smallestNumberDivisibleTill(long n) {
        long result = 1;
        for(long i = 2; i <= n; i++) {
            if(result % i != 0) {
                result *= Math.pow(i, floor(log(n)/log(i)));
            }
        }
        return result;
    }
}
