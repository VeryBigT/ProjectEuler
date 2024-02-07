package problems;

import common.Problem;

import java.util.stream.IntStream;

/**
 * Solution for <a href="https://projecteuler.net/problem=44">Problem 44</a>
 * from <a href="https://projecteuler.net/">Project Euler</a>
 */
public class Problem44 extends Problem {
    public static void main(String[] args) {
        new Problem44().run();
    }

    @Override
    protected void solveSimple() {
        for(int i = 1; i <= 51; i++) {
            System.out.println(i + ": " + isPN(i));
        }
    }

    @Override
    protected void solve() {
        System.out.println(findD());
    }

    private static int findD() {
        for(int i = 1; ; i++) {
            for(int m = i, n = 1; m > 1; m--, n++) {
                int pn = p(n);
                int pnm = p(n+m);
                if(isPN(pnm - pn) && isPN(pn + pnm))
                    return pnm - pn;
            }
        }
    }

    private static int findDStream() {
        return IntStream.iterate(1, i -> i + 1)
                .map(i -> IntStream.rangeClosed(1, i)
                        .filter(m -> {
                            int n = i - m + 1;
                            int pn = p(n);
                            int pnm = p(n+m);
                            return isPN(pnm - pn) && isPN(pn + pnm);
                        })
                        .map(m -> f(i - m + 1, m))
                        .findFirst().orElse(-1))
                .filter(i -> i != -1)
                .findFirst().orElse(-1);
    }

    private static int f(int n, int m) {
        return m * (3 * m + 6 * n - 1) / 2;
    }

    private static int p(int n) {
        return n * (3 * n - 1) / 2;
    }

    private static boolean isPN(int pn) {
        double n = 1./6. * (Math.sqrt(24 * pn + 1) + 1);
        return (int) n == n;
    }
}