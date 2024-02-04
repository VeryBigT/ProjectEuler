package problems;

import common.Problem;

/**
 * Solution for <a href="https://projecteuler.net/problem=40">Problem 40</a>
 * from <a href="https://projecteuler.net/">Project Euler</a>
 */
public class Problem40 extends Problem {
    public static void main(String[] args) {
        new Problem40().run();
    }

    @Override
    protected void solveSimple() {
    }

    @Override
    protected void solve() {
        System.out.println(shampernownesConstant());
    }

    private int shampernownesConstant() {
        StringBuilder sb = new StringBuilder("0123456789");
        int i = 10;
        do {
            sb.append(i++);
        } while(sb.length() <= 1_000_000);
        int result = 1;
        for(int j = 1; j <= 1_000_000; j *= 10)
            result *= sb.charAt(j) - '0';
        return result;
    }
}