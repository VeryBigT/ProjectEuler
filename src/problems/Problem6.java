package problems;

import common.Problem;

/**
 * Solution for <a href="https://projecteuler.net/problem=6">Problem 6</a>
 * from <a href="https://projecteuler.net/">Project Euler</a>
 */
public class Problem6 extends Problem {
    public static void main(String[] args) {
        new Problem6().run();
    }

    @Override
    protected void solveSimple() {
        System.out.println(sumSquareDifference(10));
    }

    @Override
    protected void solve() {
        System.out.println(sumSquareDifference(100));
    }

    static int sumSquareDifference(int n) {
        return squareOfSum(n) - sumOfSquares(n);
    }

    private static int sumOfSquares(int n) {
        //int result = 0;
        //for(int i = 0, square = 1, odd = 3; i < n; i++, result += square, square += odd, odd += 2);
        //return result;
        return (2 * n + 1) * (n + 1) * n / 6;
    }

    private static int squareOfSum(int n) {
        int result = n * (n+1) / 2;
        return result * result;
    }
}
