package me.pafias.aoc;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static int part1(List<String> lines) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        lines.forEach(line -> {
            String[] split = line.split("   ");
            list1.add(Integer.valueOf(split[0].trim()));
            list2.add(Integer.valueOf(split[1].trim()));
        });
        List<Integer> sortedList1 = list1.stream().sorted().toList();
        List<Integer> sortedList2 = list2.stream().sorted().toList();
        int total = 0;
        for (int i = 0; i < sortedList1.size(); i++) {
            int n1 = sortedList1.get(i);
            int n2 = sortedList2.get(i);
            int distance = Math.abs(n2 - n1);
            total += distance;
        }
        return total;
    }

    public static int part2(List<String> lines) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        lines.forEach(line -> {
            String[] split = line.split("   ");
            list1.add(Integer.valueOf(split[0].trim()));
            list2.add(Integer.valueOf(split[1].trim()));
        });
        List<Integer> sortedList1 = list1.stream().sorted().toList();
        List<Integer> sortedList2 = list2.stream().sorted().toList();
        int similarityScore = 0;
        for (Integer n1 : sortedList1) {
            int occurrencesInList2 = 0;
            occurrencesInList2 = (int) sortedList2.stream()
                    .filter(n2 -> n2.equals(n1))
                    .count();
            similarityScore += n1 * occurrencesInList2;
        }
        return similarityScore;
    }

    public static List<String> readFileLines(String file) throws Exception {
        return Files.readAllLines(Path.of(Main.class.getResource(file).toURI()));
    }

}