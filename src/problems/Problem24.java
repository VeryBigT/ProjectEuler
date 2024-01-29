package problems;

import common.Problem;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * Solution for <a href="https://projecteuler.net/problem=24">Problem 24</a>
 * from <a href="https://projecteuler.net/">Project Euler</a>
 */
public class Problem24 extends Problem {
    public static void main(String[] args) {
        new Problem24().runBoth();
    }

    @Override
    protected void solveSimple() {
        int[] alphabet1 = new int[]{0, 1};
        System.out.println(nThPermutation(alphabet1, 0));
        System.out.println(nThPermutation(alphabet1, 1));

        int[] alphabet2 = new int[]{0, 1, 2};
        System.out.println(nThPermutation(alphabet2, 0));
        System.out.println(nThPermutation(alphabet2, 1));
        System.out.println(nThPermutation(alphabet2, 2));
        System.out.println(nThPermutation(alphabet2, 3));
        System.out.println(nThPermutation(alphabet2, 4));
        System.out.println(nThPermutation(alphabet2, 5));
    }

    @Override
    protected void solve() {
        int[] alphabet = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(nThPermutation(alphabet, 999_999));
    }

    private static long nThPermutationRekursive(int[] alphabet, int n) {
        if(alphabet.length == 1)
            return alphabet[0];
        int f = factorial(alphabet.length - 1);
        int firstLetter = alphabet[n / f];
        n %= f;
        return powerOfTen(alphabet.length-1) * firstLetter
                + nThPermutation(removeLetter(alphabet, firstLetter), n);
    }

    private static long nThPermutation(int[] alphabet, int n) {
        long result = 0;
        int f = factorial(alphabet.length - 1);
        while(alphabet.length > 1) {
            result *= 10;
            int firstLetter = alphabet[n / f];
            n %= f;
            result += firstLetter;
            alphabet = removeLetter(alphabet, firstLetter);
            f /= alphabet.length;
        }
        return result * 10 + alphabet[0];
    }

    //ten to the power of exp (so I don't have to use Math.pow())
    private static long powerOfTen(int exp) {
        return LongStream.range(0, exp)
                .reduce(1, (a,b) -> a * 10);
    }

    //removes the number n form the array
    private static int[] removeLetter(int[] array, int n) {
        return IntStream.of(array)
                .filter(i -> i != n)
                .toArray();
    }

    private static int factorial(int n) {
        return IntStream.rangeClosed(1, n)
                .reduce(1, (a,b) -> a * b);
    }
}
