package problems;

import common.Problem;

/**
 * Solution for <a href="https://projecteuler.net/problem=28">Problem 28</a>
 * from <a href="https://projecteuler.net/">Project Euler</a>
 */
public class Problem28 extends Problem {
    public static void main(String[] args) {
        new Problem28().runBoth();
    }

    @Override
    protected void solveSimple() {
        System.out.println(numberSpiralDiagonals(5));
    }

    @Override
    protected void solve() {
        System.out.println(numberSpiralDiagonals(1001));
    }

    private static int numberSpiralDiagonals(int size) {
        int result = 0;
        for(int n = 1, i = 0, step = 2; step < size; n += step, i++) {
            if(i / 4 == 1) {
                i = 0;
                step += 2;
            }
            result += n;
        }
        return result;
    }
}