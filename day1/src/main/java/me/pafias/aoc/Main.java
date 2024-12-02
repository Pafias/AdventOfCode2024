package me.pafias.aoc;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        List<String> lines = Files.readAllLines(Path.of(Main.class.getResource("/input.txt").toURI()));
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        lines.forEach(line -> {
            String[] split = line.split("   ");
            list1.add(split[0].trim());
            list2.add(split[1].trim());
        });
        List<String> sortedList1 = list1.stream().sorted().toList();
        List<String> sortedList2 = list2.stream().sorted().toList();
        int total = 0;
        for (int i = 0; i < sortedList1.size(); i++) {
            int n1 = Integer.parseInt(sortedList1.get(i));
            int n2 = Integer.parseInt(sortedList2.get(i));
            int distance = Math.abs(n2 - n1);
            total += distance;
        }
        System.out.println(total);
    }

}