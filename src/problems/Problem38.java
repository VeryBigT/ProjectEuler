package problems;

import common.Problem;
import common.util.MathUtil;

import java.util.stream.IntStream;

/**
 * Solution for <a href="https://projecteuler.net/problem=38">Problem 38</a>
 * from <a href="https://projecteuler.net/">Project Euler</a>
 */
public class Problem38 extends Problem {
    public static void main(String[] args) {
        new Problem38().run();
    }

    @Override
    protected void solveSimple() {
        System.out.println(concatenatedProduct(192, 3));
        System.out.println(concatenatedProduct(9, 5));
    }

    @Override
    protected void solve() {
        System.out.println(biggestPandigitalMultiple());
    }

    private int biggestPandigitalMultiple() {
        return IntStream.range(1, 10)
                //.parallel()   //slower
                .map(n -> IntStream.range(1, 10_000)
                        .map(i -> concatenatedProduct(i, n))
                        .takeWhile(p -> p < 1_000_000_000)
                        .filter(Problem38::isPandigital)
                        .max().orElse(-1))
                .max().orElse(-1);
    }

    private int concatenatedProduct(int i, int n) {
        int biggestDigit = MathUtil.powOfTen((int) Math.log10(i) + 1);
        int result = 0;
        for(int j = 1; j <= n; j++) {
            int product = j * i;
            result *= product < biggestDigit ?
                    biggestDigit : biggestDigit * 10;
            result += product;
        }
        return result;
    }

    private static boolean isPandigital(int n) {
        int digitMask = 0;
        while(n > 0) {
            int digit = n % 10;
            digitMask |= digit == 0 ? 0 : 1 << (digit - 1);
            n /= 10;
        }
        return digitMask == 0b1_1111_1111;
    }
}