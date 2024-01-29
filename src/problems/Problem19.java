package problems;

import common.Problem;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Solution for <a href="https://projecteuler.net/problem=19">Problem 19</a>
 * from <a href="https://projecteuler.net/">Project Euler</a>
 */
public class Problem19 extends Problem {
    public static void main(String[] args) {
        new Problem19().run();
    }

    @Override
    public void solveSimple() {
    }

    @Override
    public void solve() {
        System.out.println(sundaysOnFirstOfMonth(1901, 2000));
    }

    static int sundaysOnFirstOfMonth(int startYear, int endYear) {
        return Arrays.stream(Month.values())
                .mapToInt(month -> (int) IntStream.range(startYear, endYear + 1)
                        .mapToObj(year -> LocalDate.of(year, month, 1).getDayOfWeek())
                        .filter(dayOfWeek -> dayOfWeek == DayOfWeek.SUNDAY)
                        .count())
                .sum();
        /*int result = 0;
        for(Month m : Month.values()) {
            for(int y = startYear; y <= endYear; y++) {
                if(LocalDate.of(y, m, 1).getDayOfWeek() == DayOfWeek.SUNDAY)
                    result++;
            }
        }
        return result;*/
    }
}
