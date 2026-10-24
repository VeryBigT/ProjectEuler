package problems;

import common.Problem;
import common.util.MathUtil;

import java.util.Arrays;

/**
 * Solution for <a href="https://projecteuler.net/problem=52">Problem 52</a>
 * from <a href="https://projecteuler.net/">Project Euler</a>
 */
public class Problem52 extends Problem {
    public static void main(String[] args) {
        new Problem52().run();
    }

    @Override
    protected void solveSimple() {
        System.out.println(smallestSameDigitsFamily(2));
    }

    @Override
    protected void solve() {
        System.out.println(smallestSameDigitsFamily(2, 3, 4, 5, 6));
    }

    private int smallestSameDigitsFamily(int... multiplier) {
        int i = 1;
        while(true) {
            i++;
            int[] digits1 = MathUtil.digitArray(i), digits2;
            boolean flag = true;
            for(int m : multiplier) {
                digits2 = MathUtil.digitArray(i * m);
                if(!Arrays.equals(digits1, digits2)) {
                    flag = false;
                    break;
                }
            }
            if(flag)
                break;
        }
        return i;
    }
}