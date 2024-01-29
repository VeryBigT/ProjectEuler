package problems;

import common.Problem;

import java.util.stream.IntStream;

/**
 * Solution for <a href="https://projecteuler.net/problem=17">Problem 17</a>
 * from <a href="https://projecteuler.net/">Project Euler</a>
 */
public class Problem17 extends Problem {
    public static void main(String[] args) {
        new Problem17().run();
    }

    @Override
    public void solveSimple() {
        System.out.println(numberLetterCountOfAllNumbersTill(5));
    }

    @Override
    public void solve() {
        System.out.println(numberLetterCountOfAllNumbersTill(1000));
    }

    static int numberLetterCountOfAllNumbersTill(int i) {
        return IntStream.range(1, i+1)
                .map(Problem17::numberLetterCount)
                .sum();
    }

    static int numberLetterCount(int i) {
        if(i > 1000)
            throw new IllegalArgumentException("i only up to 1000 expected!");
        if(i == 1000) {
            //System.out.println("1000 -> 1, 0, 0, 0 -> " + "onethousand".length() + "letters");
            return "onethousand".length();
        }
        int hundreds = (i - i % 100) / 100;
        int tens = (i % 100 - i % 10) / 10;
        int ones = i % 10;
        int hundredsLetters = hundreds == 0 ? 0 : digitLetterCount(hundreds) + "hundred".length();
        int tensAndOnesLetters = tensAndOnesLetterCount(tens, ones);
        int result = hundredsLetters + tensAndOnesLetters;
        if(hundredsLetters != 0 && tensAndOnesLetters != 0)
            result += "and".length();
        //System.out.printf("%d -> %d, %d, %d -> %d letters%n", i, hundreds, tens, ones, result);
        return result;
    }

    static int digitLetterCount(int digit) {
        return switch(digit) {
            case 1, 2, 6 -> 3;  //one two six
            case 4, 5, 9 -> 4;  //four five nine
            case 3, 7, 8 -> 5;  //three seven eight
            case 0 -> 0;
            default -> throw new IllegalStateException("Unexpected value: " + digit);
        };
    }

    static int tensAndOnesLetterCount(int tens, int ones) {
        if(tens == 1) {
            return switch(ones) {
                case 0 -> 3;            //ten
                case 1, 2 -> 6;         //eleven twelve
                case 5, 6 -> 7;         //fifteen sixteen
                case 3, 4, 8, 9 -> 8;   //thirteen fourteen eighteen nineteen
                case 7 -> 9;            //seventeen
                default -> throw new IllegalStateException("Unexpected value: " + ones);
            };
        }
        else {
            return digitLetterCount(ones) + switch(tens) {
                case 0 -> 0;
                case 4, 5, 6 -> 5;      //forty fifty sixty
                case 2, 3, 8, 9 -> 6;   //twenty thirty eighty ninety
                case 7 -> 7;            //seventy
                default -> throw new IllegalStateException("Unexpected value: " + tens);
            };
        }
    }
}
