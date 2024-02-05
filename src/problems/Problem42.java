package problems;

import common.Problem;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Solution for <a href="https://projecteuler.net/problem=42">Problem 42</a>
 * from <a href="https://projecteuler.net/">Project Euler</a>
 */
public class Problem42 extends Problem {
    public static void main(String[] args) {
        new Problem42().run();
    }

    @Override
    protected void solveSimple() {
        for(int i = 1; i < 56; i++) {
            System.out.println(i + ": " + isTriangleNumber(i));
        }
        String[] words = {"SKY"};
        System.out.println(numTriangleWords(words));
        //System.out.println(numTriangleWordsSmart(words));
    }

    @Override
    protected void solve() {
        String[] words = Problem22.getWords("src/files/0042_words.txt");
        System.out.println(numTriangleWords(words));
        //System.out.println(numTriangleWordsSmart(words));
    }

    private static int numTriangleWords(String[] words) {
        Map<Integer, Long> scores = Arrays.stream(words)
                .collect(Collectors.groupingBy(Problem22::wordScore, Collectors.counting()));
        int maxScore = scores.keySet().stream()
                .mapToInt(k -> k)
                .max().orElse(-1);
        int[] triangleNumbers = allTriangleNumbersTill(maxScore);
        return scores.entrySet().stream()
                .filter(e -> Arrays.binarySearch(triangleNumbers, e.getKey()) >= 0)
                .mapToInt(e -> Math.toIntExact(e.getValue()))
                .sum();
    }

    private static int numTriangleWordsSmart(String[] words) {
        return (int) Arrays.stream(words)
                .mapToInt(Problem22::wordScore)
                .filter(Problem42::isTriangleNumber)
                .count();
    }

    private static int[] allTriangleNumbersTill(int max) {
        return IntStream.iterate(1, i -> i + 1)
                .map(n -> n * (n + 1) / 2)
                .takeWhile(t -> t <= max)
                .toArray();
    }

    private static boolean isTriangleNumber(int i) {
        double n = Math.sqrt(2 * i + .25) - 0.5;
        return n == (int) n;
    }
}