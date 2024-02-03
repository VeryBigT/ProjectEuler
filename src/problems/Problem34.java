package problems;

import common.Problem;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution for <a href="https://projecteuler.net/problem=34">Problem 34</a>
 * from <a href="https://projecteuler.net/">Project Euler</a>
 */
public class Problem34 extends Problem {
    public static void main(String[] args) {
        new Problem34().run();
    }

    @Override
    protected void solveSimple() {
    }

    @Override
    protected void solve() {
        System.out.println(digitFactorials().stream().mapToInt(Integer::intValue).sum());
    }

    private List<Integer> digitFactorials() {
        List<Integer> results = new ArrayList<>();
        int[] factorials = new int[10];
        factorials[0] = 1;
        for(int i = 1; i < 10; i++) {
            factorials[i] = factorials[i-1] * i;
        }
        for(int i = 10; i < 999_999; i++) {
            int digitSum = 0;
            int number = i;
            while(number > 0) {
                digitSum += factorials[number % 10];
                number /= 10;
            }
            if(i == digitSum)
                results.add(i);
        }
        //System.out.println(results);
        return results;
    }
}