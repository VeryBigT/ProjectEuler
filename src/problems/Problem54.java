package problems;

import common.Problem;
import common.util.collections.CountMap;
import common.util.io.FileReader;

import java.util.Arrays;
import java.util.List;

/**
 * Solution for <a href="https://projecteuler.net/problem=54">Problem 54</a>
 * from <a href="https://projecteuler.net/">Project Euler</a>
 */
public class Problem54 extends Problem {
    public static void main(String[] args) {
        new Problem54().run();
    }

    @Override
    protected void solveSimple() {
    }

    @Override
    protected void solve() {
        List<String> input = FileReader.readFile("src/files/0054_poker.txt");
        int player1Score = 0;
        for (String line : input) {
            Hand hand1 = new Hand(line.substring(0, 14));
            Hand hand2 = new Hand(line.substring(15));
            //System.out.print(hand1 + " " + hand2);
            if (hand1.compareTo(hand2) > 0)
                player1Score++;
        }
        System.out.println(player1Score);
    }

    private record Card(int value, char suit) implements Comparable<Card> {
        Card(String card) {
            this(charToValue(card.charAt(0)), card.charAt(1));
        }

        private static int charToValue(char ch) {
            return switch (ch) {
                case 'T' -> 10;
                case 'J' -> 11;
                case 'Q' -> 12;
                case 'K' -> 13;
                case 'A' -> 14;
                default -> ch - '0';
            };
        }

        private static char valueToChar(int v) {
            return switch (v) {
                case 10 -> 'T';
                case 11 -> 'J';
                case 12 -> 'Q';
                case 13 -> 'K';
                case 14 -> 'A';
                default -> (char) ('0' + v);
            };
        }

        @Override
        public int compareTo(Card o) {
            return o.value - value;
        }

        @Override
        public String toString() {
            return "" + valueToChar(value) + suit;
        }
    }

    private record Hand(Card[] cards) implements Comparable<Hand> {
        Hand(String hand) {
            this(Arrays.stream(hand.split(" "))
                    .map(Card::new)
                    .sorted()
                    .toArray(Card[]::new));
        }

        int rank() {
            boolean isFlush = isFlush(),
                    isStraight = isStraight();
            if(isFlush && isStraight)
                return 9;
            if(isFlush)
                return 6;
            if(isStraight)
                return 5;
            int[] duplicates = duplicates();
            if(duplicates[2] == 1)
                return 8;
            if(duplicates[0] == 1 && duplicates[1] == 1)
                return 7;
            if(duplicates[1] == 1)
                return 4;
            if(duplicates[0] == 2)
                return 3;
            if(duplicates[0] == 1)
                return 2;
            return 1;
        }

        private boolean isFlush() {
            char firstSuit = cards[0].suit;
            for(int i = 1; i < cards.length; i++)
                if(cards[i].suit  != firstSuit)
                    return false;
            return true;
        }

        private boolean isStraight() {
            int lastValue = cards[0].value;
            for(int i = 1; i < cards.length; i++) {
                if (cards[i].value - lastValue != -1)
                    return false;
                lastValue = cards[i].value;
            }
            return true;
        }

        private int[] duplicates() {
            int[] result = new int[3];
            CountMap<Integer> values = new CountMap<>();
            Arrays.stream(cards).forEach(card -> values.add(card.value));
            for(var e : values.entrySet()) {
                int v = e.getValue();
                if (v > 1)
                    result[v-2]++;
            }
            return result;
        }

        @Override
        public int compareTo(Hand o) {
            int rank1 = this.rank(), rank2 = o.rank();
            if (rank1 != rank2)
                return rank1 - rank2;
            int score1 = score(rank1), score2 = o.score(rank2);
            if (score1 != score2)
                return score1 - score2;
            for(int i = 0; i < cards.length; i++)
                if(cards[i].value != o.cards[i].value)
                    return cards[i].value - o.cards[i].value;
            return 0;
        }

        private int score(int rank) {
            int cardValue1 = 0, cardValue2 = 0;
            int lastValue, i, j;
            switch (rank) {
                case 1:
                    cardValue1 = cards[0].value;
                    cardValue2 = cards[1].value;
                    break;
                case 2:
                    lastValue = cards[0].value;
                    for(i = 1; i < cards.length; i++) {
                        if(cards[i].value == lastValue) {
                            cardValue1 = lastValue;
                            break;
                        }
                        lastValue = cards[i].value;
                    }
                    break;
                case 3:
                    lastValue = cards[0].value;
                    for(i = 1; i < cards.length; i++) {
                        if(cards[i].value == lastValue) {
                            cardValue1 = lastValue;
                            break;
                        }
                        lastValue = cards[i].value;
                    }
                    lastValue = cards[i+1].value;
                    for(j = i + 2; j < cards.length; j++) {
                        if(cards[j].value == lastValue) {
                            cardValue2 = lastValue;
                            break;
                        }
                        lastValue = cards[j].value;
                    }
                    break;
                case 4:
                    for(i = 2; i < cards.length; i++) {
                        if(cards[i].value == cards[i-1].value) {
                            cardValue1 = cards[i].value;
                            break;
                        }
                    }
                    break;
                case 5:
                case 6:
                case 9:
                    cardValue1 = cards[0].value;
                    break;
                case 7:
                    if(cards[0].value == cards[2].value) {
                        cardValue1 = cards[0].value;
                        cardValue2 = cards[4].value;
                    }
                    else {
                        cardValue1 = cards[4].value;
                        cardValue2 = cards[0].value;
                    }
                    break;
                case 8:
                    if(cards[0].value == cards[1].value)
                        cardValue1 = cards[0].value;
                    else
                        cardValue1 = cards[1].value;
                    break;
            }
            return (cardValue1 << 4) | cardValue2;
        }

        @Override
        public String toString() {
            return Arrays.toString(cards);
        }
    }
}