package problems;

import common.Problem;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.function.Function;

/**
 * Solution for <a href="https://projecteuler.net/problem=25">Problem 25</a>
 * from <a href="https://projecteuler.net/">Project Euler</a>
 */
public class Problem25 extends Problem {
    public static void main(String[] args) {
        new Problem25().run();
    }

    @Override
    protected void solveSimple() {
        System.out.println(indexOfFirstFibWithNDigits(1));
        System.out.println(indexOfFirstFibWithNDigits(2));
        System.out.println(indexOfFirstFibWithNDigits(3));
        System.out.println(indexOfFirstFibWithNDigits(4));
    }

    @Override
    protected void solve() {
        System.out.println(indexOfFirstFibWithNDigits(1000));
    }

    private static int indexOfFirstFibWithNDigits(int n) {
        return findFirst(BigInteger.TEN.pow(n-1), 1, Problem25::fib_n);
    }

    private static int findFirst(BigInteger value, int startIndex, Function<Integer, BigInteger> func) {
        int right = startIndex;
        //double index until bigger
        while(func.apply(right).compareTo(value) < 0) {
            right *= 2;
        }
        //binary search
        int left = right / 2;
        while (left <= right) {
            int mid = (left + right) / 2;
            if(func.apply(mid).compareTo(value) < 0)
                left = mid + 1;
            else
                right = mid - 1;
        }
        //System.out.printf("Fib_%d = %s%n", left, func.apply(left).toString());
        return left;
    }

    private static final BigDecimal one_plus_sqrt5_over2 = BigDecimal.valueOf((1+Math.sqrt(5))/2);

    private static final BigDecimal one_minus_sqrt5_over2 =  BigDecimal.valueOf((1-Math.sqrt(5))/2);

    private static final BigDecimal one_over_sqrt5 = BigDecimal.valueOf(1/Math.sqrt(5));

    static BigInteger fib_n(int n) {
        return one_plus_sqrt5_over2.pow(n)
                .subtract(one_minus_sqrt5_over2.pow(n))
                .multiply(one_over_sqrt5).toBigInteger();
    }
}
