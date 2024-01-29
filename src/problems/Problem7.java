package problems;

import common.Problem;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution for <a href="https://projecteuler.net/problem=7">Problem 7</a>
 * from <a href="https://projecteuler.net/">Project Euler</a>
 */
public class Problem7 extends Problem {
    public static void main(String[] args) {
        new Problem7().run();
    }

    @Override
    protected void solveSimple() {
        System.out.println(nthPrime(6));
    }

    @Override
    protected void solve() {
        System.out.println(nthPrime(10_001));
    }

    static long nthPrime(int n) {
        List<Long> primes = new ArrayList<>();
        primes.add(2L);
        primes.add(3L);
        while(primes.size() < n) {
            for(long i = primes.get(primes.size()-1) + 2; true; i += 2) {
                boolean isPrime = true;
                for(long prime : primes) {
                    if(i % prime == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if(isPrime) {
                    primes.add(i);
                    break;
                }
            }
        }
        return primes.get(primes.size() - 1);
    }
}
