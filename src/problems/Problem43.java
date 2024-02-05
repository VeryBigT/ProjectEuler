package problems;

import common.Problem;

import java.util.*;
import java.util.function.LongSupplier;
import java.util.stream.LongStream;

/**
 * Solution for <a href="https://projecteuler.net/problem=43">Problem 43</a>
 * from <a href="https://projecteuler.net/">Project Euler</a>
 */
public class Problem43 extends Problem {
    public static void main(String[] args) {
        new Problem43().run();
    }

    @Override
    protected void solveSimple() {
    }

    @Override
    protected void solve() {
        System.out.println(numSubStringDivisible());
    }

    private static long numSubStringDivisible() {
        return LongStream.generate(new MySupplier())
                .takeWhile(L -> L != -1)
                //.peek(System.out::println)
                .sum();
    }

    static class MyIterator implements Iterator<Long> {
        byte[] digits = {1, 0, 2, 3, 4, 5, 6, 7, 8, 9};

        static final byte[] maxDigits = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

        public boolean hasNext() {
            return !Arrays.equals(digits, maxDigits);
        }

        public Long next() {
            do {
                swap();
                if(!hasNext())
                    return -1L;
            } while ((digits[3]) % 2 != 0
                    || (digits[2] + digits[3] + digits[4]) % 3 != 0
                    || (digits[5]) % 5 != 0
                    || (digits[4] * 100 + digits[5] * 10 + digits[6]) % 7 != 0
                    || (digits[5] * 100 + digits[6] * 10 + digits[7]) % 11 != 0
                    || (digits[6] * 100 + digits[7] * 10 + digits[8]) % 13 != 0
                    || (digits[7] * 100 + digits[8] * 10 + digits[9]) % 17 != 0);
            return toLong();
        }

        private void swap() {
            for(int left = 8; left >= 0; left--) {
                byte minBigger = Byte.MAX_VALUE;
                int minBiggerIdx = left;
                for (int right = left + 1; right <= 9; right++) {
                    if (digits[right] > digits[left] && digits[right] < minBigger) {
                        minBigger = digits[right];
                        minBiggerIdx = right;
                    }
                }
                if(minBiggerIdx != left) {
                    byte tmp = digits[minBiggerIdx];
                    digits[minBiggerIdx] = digits[left];
                    digits[left] = tmp;
                    Arrays.sort(digits, left + 1, 10);
                    return;
                }
            }
        }

        private Long toLong() {
            long newNumber = 0L;
            for(int digit : digits)
                newNumber = newNumber * 10 + digit;
            return newNumber;
        }
    }

    static class MySupplier implements LongSupplier {
        Iterator<Long> it = new MyIterator();
        public long getAsLong() {
            return it.next();
        }
    }
}