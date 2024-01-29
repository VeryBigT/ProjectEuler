package problems;

import common.Problem;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Solution for <a href="https://projecteuler.net/problem=9">Problem 9</a>
 * from <a href="https://projecteuler.net/">Project Euler</a>
 */
public class Problem9 extends Problem {
    public static void main(String[] args) {
        new Problem9().run();
    }

    @Override
    protected void solveSimple() {
        int[] triplet1 = pythagoreanTripletWithSum(12);
        System.out.println(Arrays.toString(triplet1));
        System.out.println(IntStream.of(triplet1).reduce(1, (a,b) -> a * b));
    }

    @Override
    protected void solve() {
        int[] triplet2 = pythagoreanTripletWithSum(10000);
        System.out.println(Arrays.toString(triplet2));
        System.out.println(IntStream.of(triplet2).reduce(1, (a,b) -> a * b));
    }

    private static int[] pythagoreanTripletWithSum(int sum) {
        for(int c = sum / 3; c < sum; c++) {
            for(int b = (sum - c) / 2; b < c; b++) {
                int a = sum - b - c;
                if(isPythagoreanTriplet(a, b, c))
                    return new int[]{a, b, c};
            }
        }
        return new int[3];
    }

    private static boolean isPythagoreanTriplet(int a, int b, int c) {
        return a * a + b * b == c * c;
    }
}
