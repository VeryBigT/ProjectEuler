package problems;

import common.Problem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Solution for <a href="https://projecteuler.net/problem=26">Problem 26</a>
 * from <a href="https://projecteuler.net/">Project Euler</a>
 */
public class Problem26 extends Problem {
    public static void main(String[] args) {
        new Problem26().run();
    }

    @Override
    protected void solveSimple() {
        System.out.println(longestCycle(11));
    }

    @Override
    protected void solve() {
        System.out.println(longestCycle(1000));
    }

    private int longestCycle(int d) {
        return IntStream.range(2, d)
                .reduce((a,b) -> cycleLength(a) > cycleLength(b) ? a : b)
                .orElse(-1);
    }

    private static int cycleLength(int i) {
        int z = 1, q, idx;
        List<Integer> rests = new ArrayList<>();
        rests.add(1);
        while(z != 0) {
            z *= 10;
            q = z / i;
            z -= q * i;
            if((idx = rests.indexOf(z)) != -1)
                return rests.size() - idx;
            rests.add(z);
        }
        return 0;
    }
}