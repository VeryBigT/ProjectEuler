package problems;

import common.Problem;

/**
 * Solution for <a href="https://projecteuler.net/problem=39">Problem 39</a>
 * from <a href="https://projecteuler.net/">Project Euler</a>
 */
public class Problem39 extends Problem {
    public static void main(String[] args) {
        new Problem39().run();
    }

    @Override
    protected void solveSimple() {
    }

    @Override
    protected void solve() {
        System.out.println(mostSolutionsForPerimeterTill(1000));
    }

    private static int mostSolutionsForPerimeterTill(int max) {
        int[] numOfSolutionsForP = new int[max + 1];
        for(int c = 3; c < max / 2; c++) {
            for(int b = 2; b < c; b++) {
                for(int a = Math.min(b - 1, max - b - c); a > 0; a--) {
                //for(int a = 1; a < b && a + b + c <= max; a++) {
                    if(isPythagoreanTriplet(a, b, c))
                        numOfSolutionsForP[a + b + c]++;
                }
            }
        }
        return maxIdx(numOfSolutionsForP);
    }

    private static boolean isPythagoreanTriplet(int a, int b, int c) {
        return a * a + b * b == c * c;
    }

    private static int maxIdx(int[] arr) {
        int result = 0;
        int maxValue = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > maxValue) {
                maxValue = arr[i];
                result = i;
            }
        }
        return result;
    }
}