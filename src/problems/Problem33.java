package problems;

import common.Problem;

/**
 * Solution for <a href="https://projecteuler.net/problem=33">Problem 33</a>
 * from <a href="https://projecteuler.net/">Project Euler</a>
 */
public class Problem33 extends Problem {
    public static void main(String[] args) {
        new Problem33().run();
    }

    @Override
    protected void solveSimple() {
    }

    @Override
    protected void solve() {
        System.out.println(digitCancellingFractions());
    }

    private static int digitCancellingFractions() {
        int numerator = 1;
        int denominator = 1;
        for(int d = 11; d < 100; d++) {
            for(int n = 11; n < d; n++) {
                if(isDigitCancellingFractions(n, d)) {
                    numerator *= n;
                    denominator *= d;
                }
            }
        }
        return denominator / Math.max(gcd(numerator, denominator), 1);
    }

    private static int gcd(int numerator, int denominator) {
        if(denominator == 0)
            return numerator;
        return gcd(denominator, numerator % denominator);
    }

    //over engineered but works with number > 100 (kinda)
    private static boolean isDigitCancellingFractions(int n, int d) {
        String nStr = Integer.toString(n);
        String dStr = Integer.toString(d);
        float f1 = (float) n / (float) d;
        for(int i = 0; i < nStr.length(); i++) {
            char digit = nStr.charAt(i);
            if(digit == '0')
                continue;
            int j = dStr.indexOf(String.valueOf(digit));
            if(j != -1) {
                String nCopy = nStr.substring(0, i) + nStr.substring(i + 1);
                String dCopy = dStr.substring(0, j) + dStr.substring(j + 1);
                float f2 = (float) Integer.parseInt(nCopy) / (float) Integer.parseInt(dCopy);
                if(f1 == f2) {
                    //System.out.printf("%d/%d = %d/%d%n", n, d, Integer.parseInt(nCopy), Integer.parseInt(dCopy));
                    return true;
                }
            }
        }
        return false;
    }
}