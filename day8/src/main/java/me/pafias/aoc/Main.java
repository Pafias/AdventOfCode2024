package me.pafias.aoc;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {

    public static int part1(List<String> input) {
        return -1;
    }

    public static int part2(List<String> input) {
        return -1;
    }

    public static List<String> readFileLines(String file) throws Exception {
        return Files.readAllLines(Path.of(Main.class.getResource(file).toURI()));
    }

}