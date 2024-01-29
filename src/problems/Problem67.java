package problems;

import common.Problem;
import common.util.io.FileReader;

/**
 * Solution for <a href="https://projecteuler.net/problem=67">Problem 67</a>
 * from <a href="https://projecteuler.net/">Project Euler</a>
 */
public class Problem67 extends Problem {
    public static void main(String[] args) {
        new Problem67().run();
    }

    @Override
    public void solveSimple() {
    }

    @Override
    public void solve() {
        String str = FileReader.readFileAsString("src/files/0067_triangle.txt");
        int[][] triangle = Problem18.buildTriangle(str);
        System.out.println(Problem18.maximumPathSum(triangle));
    }
}
