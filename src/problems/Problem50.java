package problems;

import common.Problem;
import common.util.MathUtil;

import java.util.Arrays;

/**
 * Solution for <a href="https://projecteuler.net/problem=50">Problem 50</a>
 * from <a href="https://projecteuler.net/">Project Euler</a>
 */
public class Problem50 extends Problem {
    public static void main(String[] args) {
        new Problem50().runBoth();
    }

    @Override
    protected void solveSimple() {
        System.out.println(biggestNDigitConsecutivePrimeSum(2));
        System.out.println(biggestNDigitConsecutivePrimeSum(3));
    }

    @Override
    protected void solve() {
        System.out.println(biggestNDigitConsecutivePrimeSum(6));
    }

    private int biggestNDigitConsecutivePrimeSum(int n) {
        int[] primes = MathUtil.allPrimesSmallerThan(MathUtil.powOfTen(n));
        int biggestPrime = primes[primes.length - 1];
        int sum = 0, maxLength;
        for(int i = 0; ; i++) {
            sum += primes[i];
            if(sum > biggestPrime){
                maxLength = i;
                break;
            }
        }
        for(int length = maxLength; ; length--) {
            for(int start = 0; start < primes.length - length; start++) {
                sum = Arrays.stream(primes, start, start + length).sum();
                if(sum > biggestPrime)
                    break;
                if(Arrays.binarySearch(primes, sum) > 0)
                    return sum;
            }
        }
    }
}