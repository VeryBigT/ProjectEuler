package problems;

import common.Problem;
import common.util.MathUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Solution for <a href="https://projecteuler.net/problem=30">Problem 30</a>
 * from <a href="https://projecteuler.net/">Project Euler</a>
 */
public class Problem30 extends Problem {
    public static void main(String[] args) {
        new Problem30().runBoth();
    }

    @Override
    protected void solveSimple() {
        System.out.println(digitNthPower(4).stream().mapToInt(Integer::intValue).sum());
    }

    @Override
    protected void solve() {
        System.out.println(digitNthPower(5).stream().mapToInt(Integer::intValue).sum());
    }

    static List<Integer> digitNthPower(int n) {
        List<Integer> results = new ArrayList<>();
        int limit = MathUtil.powOfTen(n+1);
        for(int z = 2; z < limit; z++) {
            int[] digits = digitsOf(z);
            int sum = IntStream.of(digits)
                    .map(d -> MathUtil.pow(d, n))
                    .sum();
            if(sum == z)
                results.add(z);
        }
        return results;
    }

    private static int[] digitsOf(int z) {
        int[] result = new int[(int) Math.log10(z) + 1];
        for(int i = 0; i < result.length; i++) {
            result[i] = z % 10;
            z /= 10;
        }
        return result;
    }
}