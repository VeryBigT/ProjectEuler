package common.util.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FileReader {
    public static List<String> readFile(String filename) {
        File file = new File(filename);
        ArrayList<String> lines = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while(scanner.hasNextLine())
                lines.add(scanner.nextLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static String readFileAsString(String filename) {
        File file = new File(filename);
        StringBuilder text = new StringBuilder();
        try (Scanner scanner = new Scanner(file)) {
            while(scanner.hasNextLine())
                text.append(scanner.nextLine()).append("\n");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return text.toString();
    }

    public static char[][] readFileAsArray(String filename) {
        List<String> input = readFile(filename);
        char[][] arr = new char[input.size()][];
        for(int i = 0; i < input.size(); ++i) {
            arr[i] = input.get(i).toCharArray();
        }
        return arr;
    }

    public static List<Integer> stringToIntList(String str) {
        return Arrays.stream(str.split("\\s+"))
                .filter(s -> s.length() != 0)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int[] stringToIntArray(String str) {
        return Arrays.stream(str.split("\\s+"))
                .filter(s -> s.length() != 0)
                .map(Integer::parseInt)
                .mapToInt(i -> i)
                .toArray();
    }

    public static List<Long> stringToLongList(String str) {
        return Arrays.stream(str.split("\\s+"))
                .filter(s -> s.length() != 0)
                .map(Long::parseLong)
                .collect(Collectors.toList());
    }

    public static long[] stringToLongArray(String str) {
        return Arrays.stream(str.split("\\s+"))
                .filter(s -> s.length() != 0)
                .map(Long::parseLong)
                .mapToLong(l -> l)
                .toArray();
    }
}

