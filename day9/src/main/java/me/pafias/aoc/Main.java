package me.pafias.aoc;

import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    private static Disk disk;

    public static int part1(String input) {
        disk = Disk.fromMapString(input);
        System.out.println(disk);
        disk.defrag();
        System.out.println(disk);
        return disk.getChecksum();
    }

    public static int part2(String input) {
        return -1;
    }

    public static String readFileLine(String file) throws Exception {
        return Files.readString(Path.of(Main.class.getResource(file).toURI()));
    }

}