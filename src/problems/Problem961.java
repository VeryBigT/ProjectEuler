package problems;

import common.Problem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Solution for <a href="https://projecteuler.net/problem=961">Problem 961</a>
 * from <a href="https://projecteuler.net/">Project Euler</a>
 */
public class Problem961 extends Problem {
    public static void main(String[] args) {
        new Problem961().runSimple();
    }

    @Override
    protected void solveSimple() {
        int N = 10000;
        int wins = 0;
        int onesEvenZeroesEven = 0,
                onesEvenZeroesOdd = 0,
                onesOddZeroesEven = 0,
                onesOddZeroesOdd = 0;
        for (int i = 1; i < N; i++) {
            String txt = Integer.toString(i);
            int l = txt.length();
            boolean hasZeroChain = Pattern.matches("0{2,}", txt);
            txt = txt.replace("0", "");
            int nonZeroes = txt.length();
            int zeroes = l - nonZeroes;
            boolean onesEven = nonZeroes % 2 == 0;
            boolean zerosEven = zeroes % 2 == 0;
            if(!onesEven && !hasZeroChain)
                wins++;
            if(onesEven & zerosEven) {
                onesEvenZeroesEven++;
            }
            else if (!onesEven & zerosEven) {
                onesOddZeroesEven++;
            }
            else if (onesEven /*& !zerosEven*/) {
                onesEvenZeroesOdd++;
            }
            else /*if (!onesEven & !zerosEven)*/ {
                onesOddZeroesOdd++;
            }
        }

        System.out.printf("\t\t\t\t\t| ones odd (%d)\tones even (%d)\n" +
                "-------------------------------------------------------\n" +
                "zeroes odd (%d)\t| %d\t\t\t\t%d\n" +
                "zeroes even (%d)\t| %d\t\t\t\t%d\n",
                onesOddZeroesOdd + onesOddZeroesEven,
                onesEvenZeroesEven + onesEvenZeroesOdd,
                onesOddZeroesOdd + onesEvenZeroesOdd,
                onesOddZeroesOdd, onesEvenZeroesOdd,
                onesEvenZeroesEven + onesOddZeroesEven,
                onesOddZeroesEven, onesEvenZeroesEven);
        System.out.println();
        System.out.println("wins: " + wins);



    }

    @Override
    protected void solve() {

    }

    private int winningNumbersSmallerN(int n) {
        int result = 0;
        List<String> allPatterns = new ArrayList<>();
        Set<String> winningPatterns = new HashSet<>();
        winningPatterns.add("1");
        winningPatterns.add("10");


        return result;
    }

    private void simulateGame(List<String> winningPatterns, String pattern, boolean isPlayer1) {
        if (isPlayer1) {

        }
        else {

        }
    }
}