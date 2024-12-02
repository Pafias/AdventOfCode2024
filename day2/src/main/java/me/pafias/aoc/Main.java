package me.pafias.aoc;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static int part1(List<String> lines) {
        List<int[]> safe = new ArrayList<>();
        List<int[]> unsafe = new ArrayList<>();

        for (String line : lines) {
            String[] split = line.split(" ");
            int[] ints = Arrays.stream(split).mapToInt(Integer::parseInt).toArray();
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
            if (increasing == ints.length - 1 || decreasing == ints.length - 1)
                safe.add(ints);
            else
                unsafe.add(ints);
        }

        return safe.size();
    }

    public static int part2(List<String> lines) {
        return -1;
    }

    public static List<String> readFileLines(String file) throws Exception {
        return Files.readAllLines(Path.of(Main.class.getResource(file).toURI()));
    }

}