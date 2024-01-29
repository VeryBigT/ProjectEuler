package problems;

import common.Problem;

import java.util.stream.LongStream;

/**
 * Solution for <a href="https://projecteuler.net/problem=864">Problem 864</a>
 * from <a href="https://projecteuler.net/">Project Euler</a>
 */
public class Problem864 extends Problem {
    public static void main(String[] args) {
        new Problem864().runSimple();
    }

    @Override
    public void solveSimple() {
        System.out.println(C(10L));
        System.out.println(C(1000L));
    }

    @Override
    public void solve() {
        System.out.println(C(123_567_101_113L));
    }

    static long C(long max) {
        long result = max;
        long[] primes = Problem10.allPrimesSmallerThan((long) Math.sqrt(max * max + 1) / 2 + 1); // zu groﬂ!
        for(long i = 0, squarep1 = 2, odd = 3; i < max; i++, squarep1 += odd, odd += 2) {
            long fSquarep1 = squarep1;
            boolean b = LongStream.of(primes)
                    .map(p -> p * p)
                    .takeWhile(p2 -> p2 < fSquarep1)
                    .anyMatch(p2 -> fSquarep1 % p2 == 0);
            System.out.printf("(%d*%d) + 1 = %d %s%n", (i+1), (i+1), fSquarep1, b?"is not squarefree":"is squarefree");
            if(b)
                result--;
        }
        return result;
    }

    static boolean isSquareFree(long n) {
        long m = 2;
        boolean hasThisPf = false;
        while (n > 1) {
            if(n % m == 0) {
                if(hasThisPf)
                    return false;
                n /= m;
                hasThisPf = true;
            }
            else {
                m += m == 2 ? 1 : 2;
                hasThisPf = false;
            }
        }
        return true;
    }
}
