package problems;

import common.Problem;

/**
 * Solution for <a href="https://projecteuler.net/problem=45">Problem 45</a>
 * from <a href="https://projecteuler.net/">Project Euler</a>
 */
public class Problem45 extends Problem {
    public static void main(String[] args) {
        new Problem45().runBoth();
    }

    @Override
    protected void solveSimple() {
        int n = 285, m = 165, l = 143;
        int tn = 40_755, pm = 40_755, hl = 40_755;
        do {
            hl += nextH(l++);
            while(pm < hl)
                pm += nextP(m++);
            while(tn < hl)
                tn += nextT(n++);
        } while(tn != pm || pm != hl);
        System.out.println(hl);
    }

    @Override
    protected void solve() {
        int m = 165, n = 143;
        int pm = 40_755, hn = 40_755;
        do {
            hn += 4 * n++ + 1;
            while(pm < hn)
                pm += 3 * m++ + 1;
        } while(pm != hn);
        System.out.println(hn);
    }

    private static int nextT(int n) {
        return n + 1;
    }

    private static int nextP(int n) {
        return 3 * n + 1;
    }

    private static int nextH(int n) {
        return 4 * n + 1;
    }
}