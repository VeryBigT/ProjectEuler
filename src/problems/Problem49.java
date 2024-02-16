package problems;

import common.Problem;
import common.util.MathUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Solution for <a href="https://projecteuler.net/problem=49">Problem 49</a>
 * from <a href="https://projecteuler.net/">Project Euler</a>
 */
public class Problem49 extends Problem {
    public static void main(String[] args) {
        new Problem49().run();
    }

    @Override
    protected void solveSimple() {
        System.out.println(nDigitPrimePermutations(5));
        System.out.println(nDigitPrimePermutations(6).size());
        System.out.println(nDigitPrimePermutations(7).size());
        System.out.println(nDigitPrimePermutations(8).size());
    }

    @Override
    protected void solve() {
        System.out.println(nDigitPrimePermutations(4));
    }

    private static List<String> nDigitPrimePermutations(int n) {
        List<String> result = new ArrayList<>();
        int[] primes = MathUtil.allPrimesSmallerThan(MathUtil.powOfTen(n));
        int[] finalPrimes = primes;
        int from = IntStream.range(0, primes.length)
                .filter(i -> finalPrimes[i] > MathUtil.powOfTen(n - 1))
                .findFirst().orElse(0);
        primes = Arrays.copyOfRange(primes, from, primes.length);
        int prime2, prime3;
        for (int prime1 : primes) {
            prime2 = prime1 + 3330;
            if (Arrays.binarySearch(primes, prime2) < 0 || !arePermutations(prime1, prime2))
                continue;
            prime3 = prime2 + 3330;
            if (Arrays.binarySearch(primes, prime3) > 0 && arePermutations(prime2, prime3))
                result.add("" + prime1 + prime2 + prime3);
        }
        return result;
    }

    private static boolean arePermutations(int n1, int n2) {
        return Arrays.equals(digitArray(n1), digitArray(n2));
    }

    private static int[] digitArray(int n) {
        int[] result = new int[10];
        while(n > 0) {
            result[n % 10]++;
            n /= 10;
        }
        return result;
    }
}