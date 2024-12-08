package me.pafias.aoc;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static int part1(List<String> input) {
        int sum = 0;
        for (String line : input) {
            String[] split = line.split(":");
            Integer total = Integer.parseInt(split[0]);
            String[] numbersS = split[1].split(" ");
            List<Integer> numbers = new ArrayList<>();
            for (String numberS : numbersS) {
                if (numberS.isBlank()) continue;
                numbers.add(Integer.parseInt(numberS.trim()));
            }

            int i = 0;

            long now = System.currentTimeMillis();
            long timeLimit = 2000;

            while (i != total) {
                if (System.currentTimeMillis() - now > timeLimit)
                    break;
                Queue<Integer> list = new LinkedList<>(numbers);
                while (list.size() != 1) {
                    int num1 = list.poll();
                    int num2 = list.poll();
                    if (ThreadLocalRandom.current().nextBoolean()) {
                        list.add(num1 + num2);
                    } else {
                        list.add(num1 * num2);
                    }
                }
                i = list.peek();
            }

            if (i == total)
                sum += i;
        }
        return sum;
    }

    public static int part2(List<String> input) {
        return -1;
    }

    public static List<String> readFileLines(String file) throws Exception {
        return Files.readAllLines(Path.of(Main.class.getResource(file).toURI()));
    }

}