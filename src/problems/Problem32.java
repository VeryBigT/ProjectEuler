package problems;

import common.Problem;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution for <a href="https://projecteuler.net/problem=32">Problem 32</a>
 * from <a href="https://projecteuler.net/">Project Euler</a>
 */
public class Problem32 extends Problem {
    public static void main(String[] args) {
        new Problem32().run();
    }

    @Override
    protected void solveSimple() {
    }

    @Override
    protected void solve() {
        System.out.println(pandigitalProducts().stream()
                .mapToInt(Integer::intValue).sum());
    }

    private static final int ALL_DIGITS_MASK = 0b1_1111_1111;

    private static List<Integer> pandigitalProducts() {
        List<Integer> results = new ArrayList<>();
        for(int product = 1234; product < 9876; product++) {
            int productMask = digitMask(product);
            for(int multiplier = 123; multiplier <= product / 2; multiplier++) {
                if(product % multiplier != 0)
                    continue;
                int multiplierMask = digitMask(multiplier);
                int multiplicandMask = digitMask(product / multiplier);
                if((productMask ^ multiplicandMask ^ multiplierMask) == ALL_DIGITS_MASK) {
                    //System.out.printf("%d * %d = %d%n", product / multiplier, multiplier, product);
                    results.add(product);
                    break;
                }
            }
        }
        return results;
    }

    private static int digitMask(int n) {
        int result = 0;
        while(n > 0) {
            int digit = n % 10;
            result |= digit == 0 ? 0 : 1 << (digit - 1);
            n /= 10;
        }
        return result;
    }

}