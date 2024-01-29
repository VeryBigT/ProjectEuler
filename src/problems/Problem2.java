package problems;

import common.Problem;

/**
 * Solution for <a href="https://projecteuler.net/problem=2">Problem 2</a>
 * from <a href="https://projecteuler.net/">Project Euler</a>
 */
public class Problem2 extends Problem {
    public static void main(String[] args) {
        new Problem2().run();
    }

    @Override
    protected void solveSimple() {

    }

    @Override
    public void solve() {
        System.out.println(sumOfEvenFibsSmallerThan(4_000_000));
    }

    static int sumOfEvenFibsSmallerThan(int max) {
        int fib = 1, fib1 = 2, fib2, result = 2;
        while(true) {
            fib2 = fib + fib1;
            if(fib2 > max)
                break;
            if(fib2 % 2 == 0)
                result += fib2;
            fib = fib1;
            fib1 = fib2;
        }
        return result;
    }
}
