package problems;

import common.Problem;

import java.math.BigDecimal;
import java.math.BigInteger;

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

    }

    @Override
    protected void solve() {
        System.out.println(indexOfFirstFibWithNDigits(1000));
    }

    private static int indexOfFirstFibWithNDigits(int n) {
        BigInteger limit = BigInteger.TEN.pow(n-1);
        int i = 1;
        while(fib_n(i).compareTo(limit) < 0) {
            i *= 2;
        }
        //binarySearch
        return i;
    }

    static final BigDecimal one_plus_sqrt5_over2 = BigDecimal.valueOf((1+Math.sqrt(5))/2);
    static final BigDecimal one_minus_sqrt5_over2 =  BigDecimal.valueOf((1-Math.sqrt(5))/2);
    static final BigDecimal one_over_sqrt5 = BigDecimal.valueOf(1/Math.sqrt(5));

    static BigInteger fib_n(int n) {
        return one_plus_sqrt5_over2.pow(n)
                .subtract(one_minus_sqrt5_over2.pow(n))
                .multiply(one_over_sqrt5).toBigInteger();
    }
}
