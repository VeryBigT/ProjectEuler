package problems;

import common.Problem;

import java.util.*;

/**
 * Solution for <a href="https://projecteuler.net/problem=14">Problem 14</a>
 * from <a href="https://projecteuler.net/">Project Euler</a>
 */
public class Problem14 extends Problem {
    public static void main(String[] args) {
        new Problem14().run();
    }

    @Override
    public void solveSimple() {
        System.out.println(maxCollatzStoppingLength(1_000_000));
    }

    @Override
    public void solve() {
        System.out.println(maxCollatzStoppingLengthSmart(1_000_000));
    }

    static long maxCollatzStoppingLength(int n) {
        int maxLength = 0;
        int maxN = 1;
        for(int i = 2; i < n; i++) {
            int length = collatzStoppingLength(i);
            if(length > maxLength) {
                maxLength = length;
                maxN = i;
            }
        }
        return maxN;
    }

    static int maxCollatzStoppingLengthSmart(int max) {
        Map<Long, Integer> stoppingLengths = new HashMap<>();
        stoppingLengths.put(1L, 0);
        Stack<Long> newNumbers = new Stack<>();
        for(int i = 2; i < max; i++) {
            long n = i;
            while(!stoppingLengths.containsKey(n)) {
                newNumbers.push(n);
                n = step(n);
            }
            int length = stoppingLengths.get(n);
            while(!newNumbers.isEmpty())
                stoppingLengths.put(newNumbers.pop(), ++length);
        }
        int maxLength = 0;
        long maxN = 1;
        for(Map.Entry<Long, Integer> entry : stoppingLengths.entrySet()) {
            int length = entry.getValue();
            long n = entry.getKey();
            if(n < max && length > maxLength) {
                maxLength = length;
                maxN = n;
            }
        }
        return (int) maxN;
    }

    static long step(long n) {
        if(n % 2 == 0)
            return n / 2;
        else
            return 3 * n + 1;
    }

    static int collatzStoppingLength(long n) {
        int result = 0;
        while(n != 1) {
            if(n % 2 == 0)
                n /= 2;
            else
                n = 3 * n + 1;
            result++;
        }
        return result;
    }
}
