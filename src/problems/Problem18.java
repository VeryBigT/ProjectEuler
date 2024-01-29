package problems;

import common.Problem;

import java.util.Arrays;

/**
 * Solution for <a href="https://projecteuler.net/problem=18">Problem 18</a>
 * from <a href="https://projecteuler.net/">Project Euler</a>
 */
public class Problem18 extends Problem {
    public static void main(String[] args) {
        new Problem18().run();
    }

    @Override
    public void solveSimple() {
        String str = """
                   3
                  7 4
                 2 4 6
                8 5 9 3""";
        int[][] triangle = buildTriangle(str);
        //for(Node[] ints : triangle1) System.out.println(Arrays.toString(ints));
        System.out.println(maximumPathSum(triangle));
    }

    @Override
    public void solve() {
        String str = """
                              75
                             95 64
                            17 47 82
                           18 35 87 10
                          20 04 82 47 65
                         19 01 23 75 03 34
                        88 02 77 73 07 63 67
                       99 65 04 28 06 16 70 92
                      41 41 26 56 83 40 80 70 33
                     41 48 72 33 47 32 37 16 94 29
                    53 71 44 65 25 43 91 52 97 51 14
                   70 11 33 28 77 73 17 78 39 68 17 57
                  91 71 52 38 17 14 91 43 58 50 27 29 48
                 63 66 04 68 89 53 67 30 73 16 69 87 40 31
                04 62 98 27 23 09 70 98 73 93 38 53 60 04 23""";
        int[][] triangle = buildTriangle(str);
        //for(Node[] ints : triangle2) System.out.println(Arrays.toString(ints));
        System.out.println(maximumPathSum(triangle));
    }

    static int[][] buildTriangle(String str1) {
        return Arrays.stream(str1.split("\n"))
                .map(line -> Arrays.stream(line.trim().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray())
                .toArray(int[][]::new);
    }

    static int maximumPathSum(int[][] triangle) {
        fillMax(triangle);
        return triangle[0][0];
    }

    private static void fillMax(int[][] triangle) {
        for(int i = triangle.length - 2; i >= 0; i--)
            for(int j = 0; j <= i; j++)
                triangle[i][j] += Math.max(triangle[i+1][j], triangle[i+1][j+1]);
    }
}
