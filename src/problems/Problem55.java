package problems;

import common.Problem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Solution for <a href="https://projecteuler.net/problem=55">Problem 55</a>
 * from <a href="https://projecteuler.net/">Project Euler</a>
 */
public class Problem55 extends Problem {
    public static void main(String[] args) {
        new Problem55().run();
    }

    @Override
    protected void solveSimple() {
        int n = 47;
        int reversed = reverse(n);
        int sum = n + reversed;
        System.out.printf("The sum of %d and %d is %d which is%s palindromic.",
                n, reversed, sum, sum == reverse(sum) ? "" : " not");
    }

    @Override
    protected void solve() {
        int result = (int) IntStream.range(1, 10_001)
                .filter(Problem55::isLychrelNumber)
                //.peek(System.out::println)
                .count();
        System.out.println(result);
    }

    private static boolean isLychrelNumber(int number) {
        number += reverse(number);
        int reversed = reverse(number);
        for (int i = 1; i < 49; i++) {
            if (number == reversed)
                return false;
            number += reversed;
            reversed = reverse(number);
        }
        return true;
    }

    private static int reverse(int n) {
        List<Integer> digits = new ArrayList<>();
        while (n != 0) {
            digits.add(n % 10);
            n /= 10;
        }
        int result = 0;
        for (int digit : digits) {
            result *= 10;
            result += digit;
        }
        return result;
    }
}