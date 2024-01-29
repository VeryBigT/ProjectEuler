package problems;

import common.Problem;

/**
 * Solution for <a href="https://projecteuler.net/problem=4">Problem 4</a>
 * from <a href="https://projecteuler.net/">Project Euler</a>
 */
public class Problem4 extends Problem {
    public static void main(String[] args) {
        new Problem4().runSimple();
    }

    @Override
    protected void solveSimple() {
        System.out.println(biggestPalindromicNumber(2));
    }

    @Override
    protected void solve() {
        System.out.println(biggestPalindromicNumber(3));
    }

    static int biggestPalindromicNumber(int n) {
        int result = 0;
        int start = (int) Math.pow(10, n);
        int end = (int) Math.pow(10, n+1);
        for(int i = start; i < end; i++) {
            for(int j = start; j <= i; j++) {
                int z = i * j;
                if(z > result && isPalindromicNumber(z))
                    result = z;
            }
        }
        return result;
    }

    static boolean isPalindromicNumber(int n) {
        String str = String.valueOf(n);
        return str.equals(new StringBuilder(str).reverse().toString());
    }
}
