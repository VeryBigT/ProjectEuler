package problems;

import common.Problem;

/**
 * Solution for <a href="https://projecteuler.net/problem=1">Problem 1</a>
 * from <a href="https://projecteuler.net/">Project Euler</a>
 */
public class Problem1 extends Problem {
    public static void main(String[] args) {
        new Problem1().runBoth();
    }

    @Override
    public void solveSimple() {
        System.out.println(sumOfMultiplesOf3or5Till(10));
    }

    @Override
    public void solve() {
        System.out.println(sumOfMultiplesOf3or5Till(1000));
    }

    static int sumOfMultiplesOf3or5Till(int max) {
        int result = 0;
        for(int i = 1; i < max; i++) {
            if(i % 3 == 0 || i % 5 == 0)
                result += i;
        }
        return result;
    }
}
