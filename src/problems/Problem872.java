package problems;

import common.Problem;

/**
 * Solution for <a href="https://projecteuler.net/problem=872">Problem 872</a>
 * from <a href="https://projecteuler.net/">Project Euler</a>
 */
public class Problem872 extends Problem {
    public static void main(String[] args) {
        new Problem872().runBoth();
    }

    @Override
    public void solveSimple() {
        System.out.println(f(6,1));
        System.out.println(f(10,3));
    }

    @Override
    public void solve() {
        System.out.println(f(pow(10, 17), pow(9, 17)));
    }

    static long pow(long base, int exp) {
        long result = 1L;
        for(int i = 0; i < exp; i++)
            result *= base;
        return result;
    }

    static long f(long n, long k) {
        return f(n, k, 1L << (int) (Math.log(n) / Math.log(2)));
    }

    static long f(long n, long k, long maxPow) {
        if(n == k)
            return k;
        for(long i = maxPow; i >= 1; i /= 2)
            if(k + i <= n)
                return f(n, k + i, i / 2) + k;
        return 0L;
    }
}
