package me.pafias.aoc;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {

    private static final List<Stone> stones = new CopyOnWriteArrayList<>();

    public static void setup(String input) {
        for (String stone : input.split(" "))
            stones.add(new Stone(stone));
    }

    public static int part1(String input) {
        setup(input);

        int stoneCount = stones.size();

        int iterations = 0;
        while (iterations < 25) {

            List<Stone> newList = new CopyOnWriteArrayList<>();

            for (Stone stone : stones) {
                int index = stones.indexOf(stone);

                if (stone.getNumberAsInt() == 0)
                    newList.add(new Stone("1"));
                else if (stone.hasEvenLength()) {
                    long[] numbers = stone.split();
                    Stone s1 = new Stone(String.valueOf(numbers[0]));
                    Stone s2 = new Stone(String.valueOf(numbers[1]));
                    newList.add(s1);
                    newList.add(s2);
                } else
                    newList.add(new Stone(String.valueOf(stone.getNumberAsInt() * 2024)));
            }
            stones.clear();
            stones.addAll(newList);

            iterations++;
        }

        stoneCount = stones.size();

        return stoneCount;
    }

    public static int part2(String input) {
        return -1;
    }

    public static String readFileLine(String file) throws Exception {
        return Files.readString(Path.of(Main.class.getResource(file).toURI()));
    }

}