package problems;

import common.Problem;
import common.util.collections.CountMap;

/**
 * Solution for <a href="https://projecteuler.net/problem=12">Problem 12</a>
 * from <a href="https://projecteuler.net/">Project Euler</a>
 */
public class Problem12 extends Problem {
    public static void main(String[] args) {
        new Problem12().run();
    }

    @Override
    protected void solveSimple() {
        System.out.println(smallestTriangleNumberWithNDivisors(5));
    }

    @Override
    protected void solve() {
        System.out.println(smallestTriangleNumberWithNDivisors(500));
    }

    static long smallestTriangleNumberWithNDivisors(int n) {
        long triangle = 0;
        long nextN = 1;
        do {
            triangle += nextN++;
        } while(triangle < n || numDivisors(triangle) < n);
        return triangle;
    }

    static long numDivisors(long n) {
        CountMap<Integer> map = new CountMap<>();
        int m = 2;
        while (n > 1) {
            if(n % m == 0) {
                n /= m;
                map.add(m);
            }
            else
                m++;
        }
        return map.values().stream()
                .mapToLong(i -> i+1)
                .reduce(1, (e1, e2) -> e1 * e2);
    }
}
