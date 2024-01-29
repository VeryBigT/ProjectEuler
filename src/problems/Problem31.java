package problems;

import common.Problem;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Solution for <a href="https://projecteuler.net/problem=31">Problem 31</a>
 * from <a href="https://projecteuler.net/">Project Euler</a>
 */
public class Problem31 extends Problem {
    public static void main(String[] args) {
        new Problem31().runBoth();
    }

    @Override
    protected void solveSimple() {
        System.out.println(numberOfCoinSumsMemo(5));
    }

    @Override
    protected void solve() {
        System.out.println(numberOfCoinSumsMemo(200));
    }

    private static final int[] coins = new int[]{200, 100, 50, 20, 10, 5, 2, 1};

    private static final int[] coins2 = new int[]{1, 2, 5, 10, 20, 50, 100, 200};

    private static int numberOfCoinSums(int sum) {
        return numberOfCoinSums(sum, 0);
    }

    private static int numberOfCoinSumsMemo(int sum) {
        int[] ways = new int[sum + 1];
        ways[0] = 1;
        for(int coin : coins2) {
            for(int j = coin; j <= sum; j++) {
                ways[j] += ways[j - coin];
            }
        }
        return ways[sum];
    }

    private static int numberOfCoinSums(int sum, int coinIdx) {
        int biggestCoin = coins[coinIdx];
        if(sum == 0 || biggestCoin == 1)
            return 1;
        return IntStream.rangeClosed(0, sum / biggestCoin)
                .map(i -> numberOfCoinSums(sum - i * biggestCoin, coinIdx+1))
                .sum();
    }

    private static int numberOfCoinSumsStupid(int sum) {
        int result = 0;
        for(int TWO_POUND = sum / 200; TWO_POUND >= 0; TWO_POUND--)
            for(int ONE_POUND = (sum - TWO_POUND * 200) / 100; ONE_POUND >= 0; ONE_POUND--)
                for(int FIFTY_PENCE = (sum - TWO_POUND * 200 - ONE_POUND * 100) / 50; FIFTY_PENCE >= 0; FIFTY_PENCE--)
                    for(int TWENTY_PENCE = (sum - TWO_POUND * 200 - ONE_POUND * 100 - FIFTY_PENCE * 50) / 20; TWENTY_PENCE >= 0; TWENTY_PENCE--)
                        for(int TEN_PENCE = (sum - TWO_POUND * 200 - ONE_POUND * 100 - FIFTY_PENCE * 50 - TWENTY_PENCE * 20) / 10; TEN_PENCE >= 0; TEN_PENCE--)
                            for(int FIVE_PENCE = (sum - TWO_POUND * 200 - ONE_POUND * 100 - FIFTY_PENCE * 50 - TWENTY_PENCE * 20 - TEN_PENCE * 10) / 5; FIVE_PENCE >= 0; FIVE_PENCE--)
                                for(int TWO_PENCE = (sum - TWO_POUND * 200 - ONE_POUND * 100 - FIFTY_PENCE * 50 - TWENTY_PENCE * 20 - TEN_PENCE * 10 - FIVE_PENCE * 5) / 2; TWO_PENCE >= 0; TWO_PENCE--)
                                    for(int ONE_PENCE = (sum - TWO_POUND * 200 - ONE_POUND * 100 - FIFTY_PENCE * 50 - TWENTY_PENCE * 20 - TEN_PENCE * 10 - FIVE_PENCE * 5 - TWO_PENCE * 2); ONE_PENCE >= 0; ONE_PENCE--)
                                        if(TWO_POUND * 200 + ONE_POUND * 100 + FIFTY_PENCE * 50 + TWENTY_PENCE * 20 + TEN_PENCE * 10 + FIVE_PENCE * 5 + TWO_PENCE * 2 + ONE_PENCE == sum)
                                            result++;
        return result;
    }
}