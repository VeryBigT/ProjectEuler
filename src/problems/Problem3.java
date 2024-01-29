package problems;

import common.Problem;

/**
 * Solution for <a href="https://projecteuler.net/problem=3">Problem 3</a>
 * from <a href="https://projecteuler.net/">Project Euler</a>
 */
public class Problem3 extends Problem {
    public static void main(String[] args) {
        new Problem3().runBoth();
    }

    @Override
    public void solveSimple() {
        System.out.println(highestPrimeFactor(13195L));
    }

    @Override
    public void solve() {
        System.out.println(highestPrimeFactor(600_851_475_143L));
    }

    static long highestPrimeFactor(long n) {
        long m = 2;
        while (n > 1) {
            if(n % m == 0)
                n /= m;
            else
                m += m == 2 ? 1 : 2;
        }
        return m;
    }
}
