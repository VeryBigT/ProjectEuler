package problems;

import common.Problem;

/**
 * Solution for <a href="https://projecteuler.net/problem=15">Problem 15</a>
 * from <a href="https://projecteuler.net/">Project Euler</a>
 */
public class Problem15 extends Problem {
    public static void main(String[] args) {
        new Problem15().runSimple();
    }

    @Override
    public void solveSimple() {
        System.out.println(latticePaths(2));
        System.out.println(latticePaths(3));
    }

    @Override
    public void solve() {
        System.out.println(latticePaths(20));
    }

    static long latticePaths(int i) {
        return binomKof(2 * i, i);
    }

    static long binomKof(int n, int k) {
        if(k > n - k)
            return binomKof(n, n - k);
        long result = 1;
        for(int i = 1; i <= k; i++, n--)
            result = result * n / i;
        return result;
    }
}
