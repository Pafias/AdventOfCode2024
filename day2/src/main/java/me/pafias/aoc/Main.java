package me.pafias.aoc;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Main {

    public static int part1(List<String> lines) {
        List<int[]> safe = new ArrayList<>();

        for (String line : lines) {
            String[] split = line.split(" ");
            int[] ints = Arrays.stream(split).mapToInt(Integer::parseInt).toArray();
            if (isSafe(ints))
                safe.add(ints);
        }

        return safe.size();
    }

    private static boolean isSafe(int[] ints) {
        int increasing = 0;
        int decreasing = 0;
        for (int i = 0; i < ints.length; i++) {
            int current = ints[i];
            if (i + 1 >= ints.length)
                break;
            int next = ints[i + 1];
            if (next > current && Math.abs(next - current) >= 1 && Math.abs(next - current) <= 3)
                increasing++;
            else if (next < current && Math.abs(next - current) >= 1 && Math.abs(next - current) <= 3)
                decreasing++;
        }
        return increasing == ints.length - 1 || decreasing == ints.length - 1;
    }

    public static int part2(List<String> lines) {
        Deque<int[]> safe = new ConcurrentLinkedDeque<>();
        Deque<int[]> unsafe = new ConcurrentLinkedDeque<>();

        for (String line : lines) {
            String[] split = line.split(" ");
            int[] ints = Arrays.stream(split).mapToInt(Integer::parseInt).toArray();
            if (isSafe(ints))
                safe.add(ints);
            else
                unsafe.add(ints);
        }

        for (int[] values : unsafe) {
            for (int i = 0; i < values.length; i++) {
                List<Integer> copy = new ArrayList<>();
                for (int value : values) {
                    copy.add(value);
                }
                copy.remove(i);
                int[] array = copy.stream().mapToInt(Integer::intValue).toArray();
                if (isSafe(array)) {
                    safe.add(array);
                    unsafe.remove(values);
                    break;
                }
            }
        }

        return safe.size();
    }

    public static List<String> readFileLines(String file) throws Exception {
        return Files.readAllLines(Path.of(Main.class.getResource(file).toURI()));
    }

}