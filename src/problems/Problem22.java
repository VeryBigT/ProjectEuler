package problems;

import common.Problem;
import common.util.io.FileReader;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Solution for <a href="https://projecteuler.net/problem=22">Problem 22</a>
 * from <a href="https://projecteuler.net/">Project Euler</a>
 */
public class Problem22 extends Problem {
    public static void main(String[] args) {
        new Problem22().run();
    }

    @Override
    public void solveSimple() {
    }

    @Override
    public void solve() {
        String[] names = getNames("src/files/0022_names.txt");
        System.out.println(nameScoreSum(names));
    }

    static long nameScoreSum(String[] names) {
        Arrays.sort(names);
        return IntStream.range(0, names.length)
                .mapToLong(i -> (i + 1) * (long) nameScore(names[i]))
                .sum();
    }

    static int nameScore(String name) {
        return name.chars()
                .map(c -> c - 'A' + 1)
                .sum();
    }

    static String[] getNames(String path) {
        String names = FileReader.readFileAsString(path);
        return names.substring(1, names.length()-2)
                .split("(\",\")");
    }
}
