package problems;

import common.Problem;
import common.util.MathUtil;

/**
 * Solution for <a href="https://projecteuler.net/problem=53">Problem 53</a>
 * from <a href="https://projecteuler.net/">Project Euler</a>
 */
public class Problem53 extends Problem {
    public static void main(String[] args) {
        new Problem53().run();
    }

    @Override
    protected void solveSimple() {
        for(int n = 0; n <= 7; n++) {
            for(int r = 0; r <= n; r++) {
                System.out.print(MathUtil.binomKofL(n, r) + " ");
            }
            System.out.println();
        }
    }

    @Override
    protected void solve() {
        System.out.println(numBigBinomKof());
    }

    private int numBigBinomKof() {
        int result = 0, limit;
        for(int n = 1; n <= 100; n++) {
            limit = n / 2;
            for(int r = 0; r <= limit; r++) {
                if(MathUtil.binomKof(n, r) > 1_000_000) {
                    result += n % 2 == 0
                            ? (limit - r) * 2 + 1
                            : (limit - r + 1) * 2;
                    break;
                }
            }
        }
        return result;
    }
}